package com.distribuidorabr.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuidorabr.DAO.OrderDAO;
import com.distribuidorabr.Model.Item;
import com.distribuidorabr.Model.Order;
import com.distribuidorabr.Model.Product;
import com.distribuidorabr.Model.enums.OrderType;
import com.distribuidorabr.Service.interfaces.OrderServiceIntf;

@Service
public class OrderService implements OrderServiceIntf{

	@Autowired
	OrderDAO dao;
	
	@Autowired
	ProductService productService;
	
	@Override
	public ArrayList<Order> findAll() {
		return (ArrayList<Order>)dao.findAll();
	}

	@Override
	public Order findById(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Order save(Order order) {
		
		//matching all items to order
		for (Item item : order.getItems()) {
			item.setOrder(order);
			
			Product product = productService.findById(item.getProduct().getId());
			/* unitValue is the result of multiplying 
			 * the item quantity by the price of the product
			 */
			item.setUnitValue(item.getQuantity() * product.getPrice());
			/* if the order is a purchase, the product stock will 
			 * increase according to quantity of the item
			 */
			if(order.getType() == OrderType.PURCHASE) {
				productService.purchase(product, item.getQuantity());
				/* if the order is a sale, the product stock will 
				 * decrease according to quantity of the item
				 */
			} else if(order.getType() == OrderType.SALE){
				//productService.sale(product, item.getQuantity());
				productService.sale(product, item.getQuantity());
			} 
		}
		/*
		 * totalValue is the sum of the unit values ​​of all items in the order
		 * this attribute is calculated automatically by the method setTotalValue()
		 */
		order.setTotalValue();
		order.setDate();
		return dao.save(order);
	}

}

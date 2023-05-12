package com.distribuidorabr.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuidorabr.DAO.OrderDAO;
import com.distribuidorabr.Model.Item;
import com.distribuidorabr.Model.Order;
import com.distribuidorabr.Service.interfaces.OrderServiceIntf;

@Service
public class OrderService implements OrderServiceIntf{

	@Autowired
	OrderDAO dao;
	
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
		for (Item item : order.getItems()) {
			item.setOrder(order);
		}
		return dao.save(order);
	}

	
}

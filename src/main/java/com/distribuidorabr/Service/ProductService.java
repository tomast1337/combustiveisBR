package com.distribuidorabr.Service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuidorabr.DAO.ProductDAO;
import com.distribuidorabr.Model.Product;
import com.distribuidorabr.Service.interfaces.ProductServicetIntf;

@Service
public class ProductService implements ProductServicetIntf{

	@Autowired
	ProductDAO dao;
	
	@Override
	public ArrayList<Product> findAll() {
		return (ArrayList<Product>) dao.findAll();
	}

	@Override
	public Product findById(UUID id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Product save(Product product) {
		return dao.save(product);
	}

	@Override
	public Product update(Product product) {
		if(product.getId() != null && product.getName() != null) {
			return dao.save(product);
		} else {
			return null;
		}
		
	}

	@Override
	public void delete(UUID id) {
		dao.deleteById(id);
		
	}

	public Product sale(Product product, double quantity) {
		product.decreaseStock(quantity);
		return update(product);
	}
	
	public Product purchase(Product product, double quantity) {
		product.increaseStock(quantity);
		return update(product);
	}
	
}

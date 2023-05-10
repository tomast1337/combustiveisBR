package com.distribuidorabr.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.distribuidorabr.DAO.ProductDAO;
import com.distribuidorabr.Model.Product;
import com.distribuidorabr.Service.interfaces.ProductServicetIntf;

public class ProductService implements ProductServicetIntf{

	@Autowired
	ProductDAO dao;
	
	@Override
	public ArrayList<Product> findAll() {
		return (ArrayList<Product>) dao.findAll();
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Product save(Product product) {
		return dao.save(product);
	}

	@Override
	public Product update(Product product) {
		if(product.getId() != 0 && product.getName() != null) {
			return dao.save(product);
		} else {
			return null;
		}
		
	}

	@Override
	public void delete(int id) {
		dao.deleteById(id);
		
	}

}

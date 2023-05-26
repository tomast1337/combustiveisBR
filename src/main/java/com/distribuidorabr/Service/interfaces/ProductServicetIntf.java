package com.distribuidorabr.Service.interfaces;

import java.util.ArrayList;
import java.util.UUID;

import com.distribuidorabr.Model.Product;

public interface ProductServicetIntf {

	public ArrayList<Product> findAll();
	public Product findById(UUID id);
	public Product save(Product product);
	public Product update(Product product);
	public void delete(UUID id);
}

package com.distribuidorabr.Service.interfaces;

import java.util.ArrayList;

import com.distribuidorabr.Model.Order;

public interface OrderServiceIntf {

	public ArrayList<Order> findAll();
	public Order findById(int id);
	public Order save(Order order);
	
}

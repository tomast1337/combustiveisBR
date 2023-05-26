package com.distribuidorabr.Service.interfaces;

import java.util.ArrayList;
import java.util.UUID;

import com.distribuidorabr.Model.Order;

public interface OrderServiceIntf {

	public ArrayList<Order> findAll();
	public Order findById(UUID id);
	public Order save(Order order);
	
}

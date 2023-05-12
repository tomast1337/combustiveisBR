package com.distribuidorabr.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.distribuidorabr.Model.Order;
import com.distribuidorabr.Service.interfaces.OrderServiceIntf;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceIntf service;

	@GetMapping("/order")
	public ArrayList<Order> findAll() {
		return service.findAll();
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id) {
		Order res = service.findById(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/order")
	public ResponseEntity<Order> save(@RequestBody Order order) {
		return ResponseEntity.ok(service.save(order));
	}

}

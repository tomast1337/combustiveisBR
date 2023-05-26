package com.distribuidorabr.Controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.distribuidorabr.Model.Order;
import com.distribuidorabr.Service.interfaces.OrderServiceIntf;

import jakarta.validation.Valid;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceIntf service;

	@GetMapping("/order")
	public ResponseEntity<ArrayList<Order>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<Order> findById(@PathVariable UUID id) {
		Order res = service.findById(id);
		if (res != null) {
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/order")
	public ResponseEntity<Order> save(@Valid @RequestBody Order order) {
			Order res = service.save(order);
			if (res != null) {
				return ResponseEntity.status(HttpStatus.OK).body(res);
			}
			return ResponseEntity.badRequest().build();
	}

}

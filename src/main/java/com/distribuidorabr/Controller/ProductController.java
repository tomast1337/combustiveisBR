package com.distribuidorabr.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.distribuidorabr.Model.Product;
import com.distribuidorabr.Service.interfaces.ProductServicetIntf;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	private ProductServicetIntf service;

	@GetMapping("/products")
	public ArrayList<Product> findAll() {
		return service.findAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Product res = service.findById(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(404).build();
	}

	@PostMapping("/products")
	public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
		Product res = service.save(product);
		if (res != null) {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(product));
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/products")
	public ResponseEntity<Product> update(@RequestBody Product product) {
		Product res = service.update(product);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok(null);
	}

}

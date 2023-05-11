package com.distribuidorabr.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.distribuidorabr.Model.Employee;
import com.distribuidorabr.Service.interfaces.EmployeeServiceIntf;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceIntf service;
	
	@GetMapping("/employee")
	public ArrayList<Employee> recuperarTodos() {
		return service.findAll();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> cadastrarNovo(@RequestBody Employee employee) {
		Employee res = service.save(employee);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> alterar(@RequestBody Employee employee) {
		Employee res = service.update(employee);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/employee/id/{codigo}")
	public ResponseEntity<Employee> findById(@PathVariable Integer codigo){
		Employee res = service.findById(codigo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/employee/cpf/{cpf}")
	public ResponseEntity<Employee> findByCpf(@PathVariable String cpf){
		Employee res = service.findByCpf(cpf);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

}

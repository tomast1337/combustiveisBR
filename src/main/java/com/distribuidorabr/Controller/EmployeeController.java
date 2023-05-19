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

import com.distribuidorabr.DTO.EmployeeResponseDTO;
import com.distribuidorabr.Model.Employee;
import com.distribuidorabr.Service.interfaces.EmployeeServiceIntf;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceIntf service;
	
	@GetMapping("/employee")
	public ResponseEntity<ArrayList<EmployeeResponseDTO>> recuperarTodos() {
		ArrayList<Employee> employees = service.findAll();
		ArrayList<EmployeeResponseDTO> dtoList = new ArrayList<>();
		for(Employee employee : employees) {
			dtoList.add(new EmployeeResponseDTO(employee));
		}
		return ResponseEntity.status(HttpStatus.OK).body(dtoList);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeResponseDTO> cadastrarNovo(@RequestBody Employee employee) {
		Employee res = service.save(employee);
		if (res != null) {
			EmployeeResponseDTO employeeDTO = new EmployeeResponseDTO(res);
			return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/employee")
	public ResponseEntity<EmployeeResponseDTO> alterar(@RequestBody Employee employee) {
		Employee res = service.update(employee);
		if (res != null) {
			EmployeeResponseDTO employeeDTO = new EmployeeResponseDTO(res);
			return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<EmployeeResponseDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/employee/id/{id}")
	public ResponseEntity<EmployeeResponseDTO> findById(@PathVariable Integer id){
		Employee res = service.findById(id);
		if (res != null) {
			return ResponseEntity.status(HttpStatus.OK).body(new EmployeeResponseDTO(res));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/employee/cpf/{cpf}")
	public ResponseEntity<EmployeeResponseDTO> findByCpf(@PathVariable String cpf){
		Employee res = service.findByCpf(cpf);
		if (res != null) {
			return ResponseEntity.status(HttpStatus.OK).body(new EmployeeResponseDTO(res));
		}
		return ResponseEntity.notFound().build();
	}

}

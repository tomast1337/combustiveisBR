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

import com.distribuidorabr.Model.Company;
import com.distribuidorabr.Service.interfaces.CompanyServiceIntf;

@RestController
public class CompanyController {

	@Autowired
	private CompanyServiceIntf service;

	@GetMapping("/companies")
	public ArrayList<Company> findAll() {
		return service.findAll();
	}

	@GetMapping("/companies/id/{codigo}")
	public ResponseEntity<Company> findById(@PathVariable Integer codigo) {
		Company res = service.findById(codigo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/companies/cnpj/{cnpj}")
	public ResponseEntity<Company> findByCnpj(@PathVariable String cnpj) {
		Company res = service.findByCnpj(cnpj);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/companies")
	public ResponseEntity<Company> save(@RequestBody Company company) {
		Company res = service.save(company);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/companies")
	public ResponseEntity<Company> update(@RequestBody Company company) {
		Company res = service.update(company);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/companies/{id}")
	public ResponseEntity<Company> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok(null);
	}

	@GetMapping("/companies/search/{corporateName}")
	public ResponseEntity<Company> findByCorporateName(@PathVariable(name = "corporateName") String corporateName) {
		Company res = service.findByCorporateName(corporateName);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

}

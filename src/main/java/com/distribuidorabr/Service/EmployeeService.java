package com.distribuidorabr.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.distribuidorabr.DAO.EmployeeDAO;
import com.distribuidorabr.Exceptions.CpfAlreadyRegisteredException;
import com.distribuidorabr.Model.Employee;
import com.distribuidorabr.Service.interfaces.EmployeeServiceIntf;

@Service
public class EmployeeService implements EmployeeServiceIntf{

	@Autowired
	private EmployeeDAO dao;
	
	private PasswordEncoder encoder;
	
	public EmployeeService(PasswordEncoder encoder, EmployeeDAO dao) {
		this.dao = dao;
		this.encoder = encoder;
	}
	
	@Override
	public ArrayList<Employee> findAll() {
		return (ArrayList<Employee>)dao.findAll();
	}

	@Override
	public Employee findById(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Employee findByCpf(String cpf) {
		return dao.findByCpf(cpf).orElse(null);
	}

	@Override
	public Employee save(Employee employee) {
		Optional<Employee> emp = dao.findByCpf(employee.getCpf());
		if(emp.isPresent()) {
			throw new CpfAlreadyRegisteredException("CPF já cadastrado");
		} else {
			
			/*
			 * Password encrypted
			 * Default password generated is 
			 * the first 5 characters of employee's CPF
			 */
			employee.setPassword(encoder.encode(employee.generatePassword()));
			
			return dao.save(employee);
		}
	}

	@Override
	public Employee update(Employee employee) {
		
		if(employee.getId() != 0 && employee.getName() != null) {
			employee.setPassword(encoder.encode(employee.getPassword()));
			return dao.save(employee);
		} else {
			return null;
		}
		
	}

	@Override
	public void delete(int id) {
		dao.deleteById(id);
	}

	@Override
	public Boolean validatePassword(String password, String cpf) {
		Employee employee = findByCpf(cpf);
		return encoder.matches(password, employee.getPassword());
	}

}

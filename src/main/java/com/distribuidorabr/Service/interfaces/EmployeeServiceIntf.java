package com.distribuidorabr.Service.interfaces;

import java.util.ArrayList;
import java.util.UUID;

import com.distribuidorabr.Model.Employee;

public interface EmployeeServiceIntf {

	public ArrayList<Employee> findAll();
	public Employee findById(UUID id);
	public Employee findByCpf(String cpf);
	public Employee save(Employee employee);
	public Employee update(Employee employee);
	public void delete(UUID id);
	public Boolean validatePassword(String password, String cpf);
	
}

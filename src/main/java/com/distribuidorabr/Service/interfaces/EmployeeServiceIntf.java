package com.distribuidorabr.Service.interfaces;

import java.util.ArrayList;

import com.distribuidorabr.Model.Employee;

public interface EmployeeServiceIntf {

	public ArrayList<Employee> findAll();
	public Employee findById(int id);
	public Employee findByCpf(String cpf);
	public Employee save(Employee employee);
	public Employee update(Employee employee);
	public void delete(int id);
	public Boolean validatePassword(String password, String cpf);
	
}

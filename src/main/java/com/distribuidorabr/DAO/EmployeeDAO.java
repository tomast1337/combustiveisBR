package com.distribuidorabr.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

}

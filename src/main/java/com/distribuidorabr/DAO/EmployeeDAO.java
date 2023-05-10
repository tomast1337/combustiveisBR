package com.distribuidorabr.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByCpf(String cpf);

}

package com.distribuidorabr.DAO;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, UUID>{

	Optional<Employee> findByCpf(String cpf);

}

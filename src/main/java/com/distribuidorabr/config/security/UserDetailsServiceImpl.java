package com.distribuidorabr.config.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.distribuidorabr.DAO.EmployeeDAO;
import com.distribuidorabr.Model.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	private EmployeeDAO employeeDAO;
	
	 public UserDetailsServiceImpl(EmployeeDAO employeeDAO) {
	        this.employeeDAO = employeeDAO;
	    }
	
	 @Override
	    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
	        Employee employee = employeeDAO.findByCpf(cpf)
	                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with CPF: " + cpf));
	        return new User(employee.getUsername(), employee.getPassword(), true, true, true,true, employee.getAuthorities());
	    }

}

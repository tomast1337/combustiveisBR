package com.distribuidorabr.DTO;

import java.io.Serializable;
import java.util.List;

import com.distribuidorabr.Model.Employee;
import com.distribuidorabr.Model.Person;
import com.distribuidorabr.Model.Role;

/* 
 * This DTO doesn't have the 'password' attribute
 */
public class EmployeeResponseDTO extends Person implements Serializable{

	private static final long serialVersionUID = -461143291644800209L;

		private String name;
		
		private String cpf;
		
		private String position;
		
		private boolean status;
		
		private List<Role> roles;
		
		public EmployeeResponseDTO() {
		}
		
		public EmployeeResponseDTO(Employee employee) {
			this.id = employee.getId();
			this.email = employee.getEmail();
			this.state = employee.getState();
			this.country = employee.getCountry();
			this.phoneNumber = employee.getPhoneNumber();
			this.name = employee.getName();
			this.cpf = employee.getCpf();
			this.position = employee.getPosition();
			this.status = employee.getStatus();
			this.roles = employee.getRoles();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public List<Role> getRoles() {
			return roles;
		}

		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}
		
}

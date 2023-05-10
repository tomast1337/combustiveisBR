package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

import com.distribuidorabr.Model.enums.Role;

public class Employee extends Person implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String position;
	private boolean status;
	private String cpf;
	private String password;
	private Role role;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String position, boolean status, String cpf, String password) {
		super();
		this.name = name;
		this.position = position;
		this.status = status;
		this.cpf = cpf;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", position=" + position + ", status=" + status + ", cpf=" + cpf
				+ ", password=" + password + ", role=" + role + ", id=" + id + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", country=" + country + ", state=" + state + "]";
	}
	
}

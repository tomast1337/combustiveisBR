package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

import com.distribuidorabr.Model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee extends Person implements Serializable{

	private static final long serialVersionUID = 9049326292090559865L;

	@Column(nullable=false, length = 100)
	private String name;
	
	@Column(nullable=false, length = 20)
	private String position;
	
	@Column(nullable=false)
	private boolean status;
	
	@Column(nullable=false, length = 15, unique=true)
	private String cpf;
	
	@Column(nullable=false, length=15)
	private String password;
	
	@Enumerated(EnumType.STRING)
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

	public boolean getStatus() {
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

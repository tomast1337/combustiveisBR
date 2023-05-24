package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import com.distribuidorabr.Model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee extends Person implements Serializable{

	private static final long serialVersionUID = 9049326292090559865L;

	@Column(nullable=false, length = 100)
	@NotEmpty(message="Campo obrigatório")
	@Size(max=100, min=10, message="Nome deve conter entre 10 e 100 caracteres")
	private String name;
	
	@Column(nullable=false, length = 20)
	@NotEmpty(message="Campo obrigatório")
	private String position;
	
	@Column(nullable=false)
	@NotNull(message="Campo obrigatório")
	private boolean status;
	
	@Column(nullable=false, length = 15, unique=true)
	@NotEmpty(message="Campo obrigatório")
	@CPF(message="Necessário CPF válido")
	private String cpf;
	
	@Column(nullable=false, length=15)
	@NotEmpty(message="Campo obrigatório")
	@Size(max=15, min=4, message="Senha deve conter entre 4 e 15 caracteres")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="Campo obrigatório")
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

	public void setPassword() {
		// The password generated is the first 5 characters of employee's CPF
		this.password = getCpf().substring(0, 4);
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

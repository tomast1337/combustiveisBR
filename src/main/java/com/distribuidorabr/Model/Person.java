package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@MappedSuperclass
public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
	protected UUID id;
	
	@Column(nullable=false, length = 100)
	@Email(message = "Escreva um e-mail válido")
	@NotEmpty(message="Campo obrigatório")
	protected String email;
	
	@Column(nullable=false, length = 17)
	@NotEmpty(message="Campo obrigatório")
	protected String phoneNumber;
	
	@Column(nullable=false, length = 30)
	@NotEmpty(message="Campo obrigatório")
	protected String country;
	
	@Column(nullable=false, length = 40)
	@NotEmpty(message="Campo obrigatório")
	protected String state;
	
	public Person () {
		
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", email=" + email + ", phoneNumber=" + phoneNumber + ", country=" + country
				+ ", state=" + state + "]";
	}
	
}

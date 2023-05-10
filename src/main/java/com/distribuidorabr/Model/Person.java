package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String email;
	protected String phoneNumber;
	protected String country;
	protected String state;
	
	public Person () {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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

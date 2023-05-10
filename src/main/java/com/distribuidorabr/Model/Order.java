package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private double totalValue;
	private Date date;
	private Company company;
	
	public Order() {
		super();
	}

	public Order(int id, double totalValue, Date date, Company company) {
		super();
		this.id = id;
		this.totalValue = totalValue;
		this.date = date;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
		Order other = (Order) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", totalValue=" + totalValue + ", date=" + date + ", company=" + company + "]";
	}
	
}

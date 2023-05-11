package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idItem;
	
	@Column(nullable=false)
	private int quantity;
	
	@Column(nullable=false)
	private double unitValue;
	
	@ManyToOne
	@JoinColumn(name="id")
	@JsonIgnoreProperties("items")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Product product;
	
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(double unitValue) {
		this.unitValue = unitValue;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idItem);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return idItem == other.idItem;
	}
	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", quantity=" + quantity + ", unitValue=" + unitValue + ", order="
				+ order + ", product=" + product + "]";
	}
	
}

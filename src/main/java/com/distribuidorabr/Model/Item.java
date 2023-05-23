package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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

	private static final long serialVersionUID = 6827554926998959652L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	//@Positive(message="Insira um valor válido")
	//@NotNull(message="Campo obrigatório")
	private double quantity;
	
	@Column(nullable=false)
	//@Positive(message="Insira um valor válido")
	//@NotNull(message="Campo obrigatório")
	private double unitValue;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties("items")
	private Order order;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn
	//@NotNull(message="Campo obrigatório")
	private Product product;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
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
		Item other = (Item) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", quantity=" + quantity + ", unitValue=" + unitValue + ", order="
				+ order + ", product=" + product + "]";
	}
	
}

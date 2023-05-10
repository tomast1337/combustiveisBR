package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable{

	private static final long serialVersionUID = 1L;

	private int idItemOrder;
	private int quantity;
	private double unitValue;
	private Order order;
	private Product product;
	public int getIdItemOrder() {
		return idItemOrder;
	}
	public void setIdItemOrder(int idItemOrder) {
		this.idItemOrder = idItemOrder;
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
		return Objects.hash(idItemOrder);
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
		return idItemOrder == other.idItemOrder;
	}
	@Override
	public String toString() {
		return "Item [idItemOrder=" + idItemOrder + ", quantity=" + quantity + ", unitValue=" + unitValue + ", order="
				+ order + ", product=" + product + "]";
	}
	
}

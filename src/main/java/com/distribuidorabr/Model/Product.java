package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

import com.distribuidorabr.Model.enums.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 923768862566391954L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;
	
	@Column(length = 30)
	private String name;
	
	@Column(nullable=false)
	private double stock;
	
	@Column(nullable=false)
	private double price;
	
	@Column(nullable=false)
	private double storageCapacity;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	public Product() {
		
	}

	public Product(int idProduct, String name, double stock, double price, double storageCapacity, Category category) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.storageCapacity = storageCapacity;
		this.category = category;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(double storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduct);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return idProduct == other.idProduct;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", stock=" + stock + ", price=" + price + ", storageCapacity="
				+ storageCapacity + "]";
	}

}

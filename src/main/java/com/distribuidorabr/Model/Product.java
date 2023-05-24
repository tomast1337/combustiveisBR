package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

import com.distribuidorabr.Exceptions.InvalidStockPurchaseException;
import com.distribuidorabr.Exceptions.InvalidStockSaleException;
import com.distribuidorabr.Model.enums.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 923768862566391954L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 30)
	@NotBlank(message="Digite um nome válido")
	private String name;
	
	@Column(nullable=false)
	@NotNull(message="Campo obrigatório")
	@Positive(message="Insira um valor válido")
	private double stock;
	
	@Column(nullable=false)
	@Positive(message="Insira um valor válido")
	@NotNull(message="Campo obrigatório")
	private double price;
	
	@Column(nullable=false)
	@Positive(message="Insira um valor válido")
	@NotNull(message="Campo obrigatório")
	private double storageCapacity;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="Campo obrigatório")
	private Category category;
	
	public Product() {
		
	}

	public Product(int id, String name, double stock, double price, double storageCapacity, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.storageCapacity = storageCapacity;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public void increaseStock(double quantity) {
		validatePurchase(quantity);
		this.stock += quantity;
	}
	
	public void decreaseStock(double quantity) {
		validateSale(quantity);
		this.stock -= quantity;
	}
	
	public void validateSale(double quantity) {
		if(stock - quantity < 0) {
			throw new InvalidStockSaleException(getCategory().toString());
		}
	}
	
	public void validatePurchase(double quantity) {
		if(stock + quantity > storageCapacity) {
			throw new InvalidStockPurchaseException(getCategory().toString());
		}
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
		Product other = (Product) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", stock=" + stock + ", price=" + price + ", storageCapacity="
				+ storageCapacity + "]";
	}

}

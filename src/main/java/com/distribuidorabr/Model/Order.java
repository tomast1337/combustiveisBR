package com.distribuidorabr.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.distribuidorabr.Model.enums.OrderType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="orders")
public class Order implements Serializable{
	
	private static final long serialVersionUID = -4200924561915341468L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	@Positive(message="Insira um valor válido")
	@NotNull(message="Campo obrigatório")
	private double totalValue;
	
	@Column(name="order_date")
	@NotNull(message="Campo obrigatório")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn
	@NotNull(message="Campo obrigatório")
	private Company company;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("order")
	@NotNull(message="Campo obrigatório")
	private List<Item> items = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private OrderType type;
	
	public Order() {
		super();
	}

	public Order(int id, double totalValue, LocalDate date, Company company, List<Item> items, OrderType type) {
		super();
		this.id = id;
		this.totalValue = totalValue;
		this.date = date;
		this.company = company;
		this.items = items;
		this.type = type;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
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
		return "Order [id=" + id + ", totalValue=" + totalValue + ", date=" + date + ", company=" + company + ", items="
				+ items + ", type=" + type + "]";
	}
	
}

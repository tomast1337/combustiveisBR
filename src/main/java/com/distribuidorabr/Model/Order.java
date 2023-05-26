package com.distribuidorabr.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.distribuidorabr.enums.OrderType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="orders")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
	private UUID id;
	
	@Column(nullable=false)
	private double totalValue;
	
	@Column(name="order_date", columnDefinition = "DATE")
	private LocalDate orderDate;
	
	@ManyToOne
	@JoinColumn
	@NotNull(message="Campo obrigatório")
	private Company company;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("order")
	@NotNull(message="Campo obrigatório")
	private List<Item> items = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private OrderType type;
	
	public Order() {
		super();
	}

	public Order(UUID id, double totalValue, Company company, List<Item> items, OrderType type) {
		super();
		this.id = id;
		this.totalValue = totalValue;
		this.orderDate = LocalDate.now();
		this.company = company;
		this.items = items;
		this.type = type;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public double getTotalValue() {
		return totalValue;
	}

	/* totalValue is the sum of the unit values 
	 * ​​of all items in the order
	 */
	public void setTotalValue() {
		double totalValue = 0;
		for(Item item : items) {
			totalValue += item.getUnitValue();
		}
		this.totalValue = totalValue;
	}

	public LocalDate getDate() {
		return orderDate;
	}

	public void setDate() {
		this.orderDate = LocalDate.now();
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
		return "Order [id=" + id + ", totalValue=" + totalValue + ", orderDate=" + orderDate + ", company=" + company + ", items="
				+ items + ", type=" + type + "]";
	}
	
}

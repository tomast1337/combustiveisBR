package com.distribuidorabr.Model.enums;

public enum OrderType {
	SALE(1), PURCHASE(2);

	private final int id;

	private OrderType(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}

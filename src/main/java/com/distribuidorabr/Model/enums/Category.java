package com.distribuidorabr.Model.enums;

public enum Category {
REGULAR_GASOLINE(1), ADD_GASOLINE(2), PREMIUM_GASOLINE(3), FORMULATED_GASOLINE(4), ETHANOL(5), CNG(6), DIESEL(7);
	
	private final int id;
	
	private Category(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}

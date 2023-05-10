package com.distribuidorabr.DAO.enums;

public enum BusinessRelationship {
	CUSTOMER(1), SUPPLIER(2);
	
	private final int id;
	
	private BusinessRelationship(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}

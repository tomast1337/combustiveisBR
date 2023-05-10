package com.distribuidorabr.DAO.enums;

public enum Role {
USER(1), ADMIN(2);
	
	private final int id;
	
	private Role(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}

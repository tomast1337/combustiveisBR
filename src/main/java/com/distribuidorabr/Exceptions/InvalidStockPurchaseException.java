package com.distribuidorabr.Exceptions;

public class InvalidStockPurchaseException extends RuntimeException{

	private static final long serialVersionUID = 1470641674021240122L;

	public InvalidStockPurchaseException(String productName) {
		super(productName);
	}

}

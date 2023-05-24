package com.distribuidorabr.Exceptions;

public class InvalidStockSaleException extends RuntimeException{

	private static final long serialVersionUID = 1470641674021240122L;

	public InvalidStockSaleException(String productName) {
		super(productName);
	}

}

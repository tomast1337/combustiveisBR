package com.distribuidorabr.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.distribuidorabr.Exceptions.InvalidStockPurchaseException;
import com.distribuidorabr.Exceptions.InvalidStockSaleException;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidStockSaleException.class)
	public ResponseEntity<Object> handleInvalidStockSaleException(InvalidStockSaleException e, WebRequest request){
		Map<String, String> errorMessage = new HashMap<>();
		errorMessage.put(e.getMessage(), "insufficient stock");
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(InvalidStockPurchaseException.class)
	public ResponseEntity<Object> handleInvalidStockPurchaseException(InvalidStockPurchaseException e, WebRequest request){
		Map<String, String> errorMessage = new HashMap<>();
		errorMessage.put(e.getMessage(), "insufficient storage capacity");
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		
	}
	
}
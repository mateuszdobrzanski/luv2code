package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {
		
		// create a CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());

		// return CustomerErrorResponse	
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	
	// Add another exception handler
	// to catch any exception e.x. miss the conversion
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {
		
		// create a CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return CustomerErrorResponse	
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}

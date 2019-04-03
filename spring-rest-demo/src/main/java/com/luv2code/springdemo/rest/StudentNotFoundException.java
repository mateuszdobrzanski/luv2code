package com.luv2code.springdemo.rest;

public class StudentNotFoundException extends RuntimeException  {

	public StudentNotFoundException(String messsage, Throwable cause) {
		super(messsage, cause);
	}

	public StudentNotFoundException(String messsage) {
		super(messsage);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

	
}

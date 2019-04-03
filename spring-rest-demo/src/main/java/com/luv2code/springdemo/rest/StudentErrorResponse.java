package com.luv2code.springdemo.rest;

public class StudentErrorResponse {

	private int stataus;
	private String message;
	private long timeStamp;
	
	public StudentErrorResponse() {	}

	public StudentErrorResponse(int stataus, String message, long timeStamp) {
		this.stataus = stataus;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStataus() {
		return stataus;
	}

	public void setStataus(int stataus) {
		this.stataus = stataus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}

package com.example.controller.exception;

import java.time.ZonedDateTime;

public class CustomExceptionResponse {
	
	private ZonedDateTime timestamp;
	private int status;
	private String error;
	private String message;
	
	public CustomExceptionResponse(ZonedDateTime timestamp, int status, String error, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
	}
	
	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getError() {
		return error;
	}
	
	public String getMessage() {
		return message;
	}
	
}

package com.example.controller.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomExceptionResponse {
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String error;
	private Map<String, String> detail;
	private String message;
	
	public CustomExceptionResponse(LocalDateTime timestamp, HttpStatus status, String error, Map<String, String> detail, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.detail = detail;
		this.message = message;
	}
	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public void setDetail(Map<String, String> detail) {
		this.detail = detail;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public String getError() {
		return error;
	}
	
	public Map<String, String> getDetail() {
		return detail;
	}
	
	public String getMessage() {
		return message;
	}
	
}

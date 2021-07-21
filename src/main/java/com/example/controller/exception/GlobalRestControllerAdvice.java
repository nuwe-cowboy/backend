package com.example.controller.exception;

import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomExceptionResponse handleException(ResourceNotFoundException e) {
		return new CustomExceptionResponse(ZonedDateTime.now(), 404, "Not Found", e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomExceptionResponse handleException(IllegalArgumentException e) {
		return new CustomExceptionResponse(ZonedDateTime.now(), 400, "Bad Request", e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CustomExceptionResponse handleException(Exception e) {
		return new CustomExceptionResponse(ZonedDateTime.now(), 500, "Internal Server Error", e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
}

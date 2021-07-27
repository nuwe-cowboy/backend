package com.example.controller.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomExceptionResponse handleException(ResourceNotFoundException e) {
		return new CustomExceptionResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomExceptionResponse handleException(IllegalArgumentException e) {
		return new CustomExceptionResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomExceptionResponse handleException(MethodArgumentNotValidException e) {
		return new CustomExceptionResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomExceptionResponse handleException(HttpMessageNotReadableException e) {
		return new CustomExceptionResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	public CustomExceptionResponse handleException(Exception e) {
		return new CustomExceptionResponse(LocalDateTime.now(), HttpStatus.OK, e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
}

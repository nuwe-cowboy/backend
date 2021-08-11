package com.example.controller.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomExceptionResponse handleException(ResourceNotFoundException e) {
		return new CustomExceptionResponse(
			LocalDateTime.now(),
			HttpStatus.NOT_FOUND,
			"Resource Not Found",
			null,
			e.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomExceptionResponse handleException(MethodArgumentTypeMismatchException e) {
		return new CustomExceptionResponse(
			LocalDateTime.now(),
			HttpStatus.BAD_REQUEST,
			"Method Argument Type Mismatch",
			null,
			null);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomExceptionResponse handleException(MethodArgumentNotValidException e) {
		Map<String, String> detail = new HashMap<>();
		
		for (FieldError fieldError : e.getFieldErrors())
			detail.put(fieldError.getField(), fieldError.getDefaultMessage());
		
		return new CustomExceptionResponse(
			LocalDateTime.now(),
			HttpStatus.BAD_REQUEST,
			"Method Argument Not Valid",
			detail,
			null);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomExceptionResponse handleException(IllegalArgumentException e) {
		return new CustomExceptionResponse(
			LocalDateTime.now(),
			HttpStatus.BAD_REQUEST,
			"Illegal Argument",
			null,
			null);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomExceptionResponse handleException(HttpMessageNotReadableException e) {
		return new CustomExceptionResponse(
			LocalDateTime.now(),
			HttpStatus.BAD_REQUEST,
			"Http Message Not Readable",
			null,
			null);
	}
	
	@ExceptionHandler(MissingPathVariableException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CustomExceptionResponse handleException(MissingPathVariableException e) {
		return new CustomExceptionResponse(
			LocalDateTime.now(),
			HttpStatus.INTERNAL_SERVER_ERROR,
			"Missing Path Variable",
			null,
			null);
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CustomExceptionResponse handleException(DuplicateKeyException e) {
		return new CustomExceptionResponse(
			LocalDateTime.now(),
			HttpStatus.INTERNAL_SERVER_ERROR,
			"Duplicate Key",
			null,
			null);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	public CustomExceptionResponse handleException(Exception e) {
		return new CustomExceptionResponse(
			LocalDateTime.now(),
			HttpStatus.OK,
			"Exception",
			null,
			null);
	}
	
}

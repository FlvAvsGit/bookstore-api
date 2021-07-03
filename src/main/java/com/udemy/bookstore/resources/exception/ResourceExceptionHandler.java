package com.udemy.bookstore.resources.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.udemy.bookstore.service.exception.DataIntegrityViolationException;
import com.udemy.bookstore.service.exception.ObjectNotFndException;

@ControllerAdvice
public class ResourceExceptionHandler {
		
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(ObjectNotFndException.class)
	public ResponseEntity<StandardError> objectNotFndException (ObjectNotFndException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError (MethodArgumentNotValidException e, ServletRequest request) {
		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), 
				"Erro na validação dos Campos");
		for (FieldError xx : e.getBindingResult().getFieldErrors()) {
			error.addErrors(xx.getField(), xx.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}


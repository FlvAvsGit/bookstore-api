package com.udemy.bookstore.service.exception;

public class ObjectNotFndException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public ObjectNotFndException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ObjectNotFndException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

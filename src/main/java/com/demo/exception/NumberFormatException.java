package com.demo.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class NumberFormatException extends Exception{
	private static final long serialVersionUID = 1L;

	public NumberFormatException(String message) {
		super(message);
	}
}

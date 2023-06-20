package com.demo.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class InvalidExamIdException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidExamIdException(String message) {
		super(message);
	}
}

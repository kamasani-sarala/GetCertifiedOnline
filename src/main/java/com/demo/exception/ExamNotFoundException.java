package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class ExamNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ExamNotFoundException(String message) {
		super(message);
	}

}



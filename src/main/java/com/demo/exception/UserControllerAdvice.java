package com.demo.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {


	@ExceptionHandler(ExamNotFoundException.class)
	public ResponseEntity<String> ExamNotFoundException(ExamNotFoundException nufe) {
		return new ResponseEntity<String>(nufe.getMessage(),HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(InvalidExamIdException.class)
	public ResponseEntity<String> InvalidExamId(InvalidExamIdException uidcnn) {
		return new ResponseEntity<String>(uidcnn.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullValuesFoundException.class)
	public ResponseEntity<String> NullValuesFoundException(NullValuesFoundException invc) {
		return new ResponseEntity<String>(invc.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> NumberFormatException(NumberFormatException invc) {
		return new ResponseEntity<String>(invc.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(NullUserFoundException.class)
	public ResponseEntity<String> NullUserFoundException(NullUserFoundException invc) {
		return new ResponseEntity<String>(invc.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
}

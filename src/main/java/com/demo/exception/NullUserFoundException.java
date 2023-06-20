package com.demo.exception;

public class NullUserFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NullUserFoundException(String message) {
		super(message);
	}

}

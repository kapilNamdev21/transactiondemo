package com.api.transactional.exception;


public class TransactionNotAvailableException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TransactionNotAvailableException(String msg) {
		super(msg);
	}
	
 
}

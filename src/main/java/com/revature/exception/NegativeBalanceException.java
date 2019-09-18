package com.revature.exception;

public class NegativeBalanceException extends RuntimeException {

	public NegativeBalanceException() {
		super("Can not withdraw from a negative account balance.");
	}
	
	public NegativeBalanceException(String message) {
		super(message);
	}
	
	
//class closed	
}

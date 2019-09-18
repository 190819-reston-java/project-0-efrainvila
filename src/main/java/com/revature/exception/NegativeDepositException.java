package com.revature.exception;

public class NegativeDepositException extends RuntimeException{
	public NegativeDepositException() {
		super("Can not deposit a negative amount.");
	}
	
	public NegativeDepositException(String message) {
		super(message);
	}
	
//class closed	
}

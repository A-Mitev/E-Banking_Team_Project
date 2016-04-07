package com.example.exception;

public class BankProductException extends Exception {

	private static final long serialVersionUID = 1174073200766836232L;

	public BankProductException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public BankProductException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BankProductException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BankProductException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}

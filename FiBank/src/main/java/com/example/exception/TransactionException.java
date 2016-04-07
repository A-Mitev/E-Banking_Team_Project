package com.example.exception;

public class TransactionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2089498455544008574L;

	public TransactionException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public TransactionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public TransactionException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public TransactionException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}

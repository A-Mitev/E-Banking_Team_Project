package com.example.exception;

public class AccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5971591920558650344L;

	public AccountException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public AccountException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AccountException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AccountException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}

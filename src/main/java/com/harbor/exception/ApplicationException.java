package com.harbor.exception;

public class ApplicationException extends Exception {
	private int code = -1;

	private String message = null;

	public ApplicationException(int code, String message) {
		super(message);
		this.code = code;

	}

	public int getCode() {
		return code;
	}
}

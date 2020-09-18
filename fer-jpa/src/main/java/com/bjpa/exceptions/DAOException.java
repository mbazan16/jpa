package com.bjpa.exceptions;

import com.bjpa.exceptions.ExceptionMsgs;

@SuppressWarnings("serial")
public class DAOException extends Exception {

	private Exception exception;
	private String message;
	private boolean generated;

	public DAOException(Exception e) {
		super();
		this.exception = e;
		this.generated = Boolean.FALSE;
	}

	public DAOException(ExceptionMsgs xm) {
		super();
		this.message = xm.getDescripcion();
		this.generated = Boolean.TRUE;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isGenerated() {
		return generated;
	}

}

package com.tiburcio.bicycles.exceptions;

import java.io.Serializable;

public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorMessage(String message) {
		super();
		this.message = message;
	}

	public ErrorMessage() {
		super();
	}

}

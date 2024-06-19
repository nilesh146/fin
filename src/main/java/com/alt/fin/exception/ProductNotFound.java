package com.alt.fin.exception;

public class ProductNotFound extends RuntimeException{

	public ProductNotFound() {
		super();
	}

	public ProductNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductNotFound(String message) {
		super(message);
	}

	public ProductNotFound(Throwable cause) {
		super(cause);
	}

	


}

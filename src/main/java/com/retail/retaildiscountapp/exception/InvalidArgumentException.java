package com.retail.retaildiscountapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class custom exception class for Invalid user input.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidArgumentException(String message) {
		super(message);
	}
}

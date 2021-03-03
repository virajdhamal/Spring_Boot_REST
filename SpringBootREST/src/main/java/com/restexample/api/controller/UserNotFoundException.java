/**
 * 
 */
package com.restexample.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author virajd
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // custom exceptin handling
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}

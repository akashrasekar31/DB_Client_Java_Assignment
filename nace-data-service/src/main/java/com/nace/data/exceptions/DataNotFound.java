package com.nace.data.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFound extends RuntimeException{

	public DataNotFound(String msg) {
		super(msg);
	}
}

package com.nace.data.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		ExceptionResponse response=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	 @ExceptionHandler(MaxUploadSizeExceededException.class)
	 public ResponseEntity<Object> handleMaxSizeException(MaxUploadSizeExceededException exc,WebRequest request) {
		 ExceptionResponse response=new ExceptionResponse(new Date(), "File too large!", request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.EXPECTATION_FAILED);
	  }
	 
	 @ExceptionHandler(DataNotFound.class)
	 public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){
		 ExceptionResponse response=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		 return new ResponseEntity(response,HttpStatus.NOT_FOUND);
	}
}

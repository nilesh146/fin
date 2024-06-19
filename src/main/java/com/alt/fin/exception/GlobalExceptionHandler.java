package com.alt.fin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alt.fin.pojo.AppError;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AppError> handleException(Exception e) {
		
		AppError er = new AppError("internal Server erro");
		
		return new ResponseEntity<AppError>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<AppError> handleProductNotFound(Exception e) {
		
		AppError er = new AppError("product not found");
		
		return new ResponseEntity<AppError>(er, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<AppError> handleEntityNotFoundException(Exception e) {
		
		AppError er = new AppError("product not found");
		
		return new ResponseEntity<AppError>(er, HttpStatus.NOT_FOUND);
	}

}

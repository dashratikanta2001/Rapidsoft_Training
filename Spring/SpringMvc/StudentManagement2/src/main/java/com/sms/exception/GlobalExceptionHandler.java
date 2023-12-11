package com.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
		// TODO Auto-generated method stub
		
		ErrorResponse<?> errorResponse = new ErrorResponse<>();
		errorResponse.setErrorMessage("Invalid email address format");
		errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setSuccess(false);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentTypeMismatchException ex) {
		// TODO Auto-generated method stub
		
		ErrorResponse<?> errorResponse = new ErrorResponse<>();
		errorResponse.setErrorMessage("ID should be a number");
		errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setSuccess(false);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
//
package com.sms.exception;

import org.hibernate.service.spi.ServiceException;
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
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.name());
		errorResponse.setError(true);
		errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage("Invalid Email address format");

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentTypeMismatchException ex) {
		// TODO Auto-generated method stub

		ErrorResponse<?> errorResponse = new ErrorResponse<>();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.name());
		errorResponse.setError(true);
		errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage("ID should be a number ");

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<?> handleServiceException(ServiceException e) {
		ErrorResponse<?> errorResponse = new ErrorResponse<>();

		errorResponse.setStatus(HttpStatus.NO_CONTENT.name());
		errorResponse.setError(true);
		errorResponse.setCode(HttpStatus.NO_CONTENT.value());
		errorResponse.setMessage(e.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
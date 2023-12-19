package com.blog.exceptions;

import java.util.HashMap; 
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.blog.response.ErrorResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> ResourceNotFoundException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ErrorResponse<?> errorResponse = new ErrorResponse<>(message, true);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<String, String>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);

		});

		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> apiExceptionHandler(ApiException ex) {
		String message = ex.getMessage();
		ErrorResponse<?> errorResponse = new ErrorResponse<>(message, true);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> numberFormtExceptionHandler(MethodArgumentTypeMismatchException ex) {
		
		String m = ex.getMessage().substring(ex.getMessage().lastIndexOf("For input string: \""));
		
		String message = "Can not convert "+m+" to number.";
		ErrorResponse<?> errorResponse = new ErrorResponse<>(message, false);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> ExceptionHandler(Exception ex) {

		String message = ex.getMessage();
		ErrorResponse<?> apiResponse = new ErrorResponse<>(message, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	}
}

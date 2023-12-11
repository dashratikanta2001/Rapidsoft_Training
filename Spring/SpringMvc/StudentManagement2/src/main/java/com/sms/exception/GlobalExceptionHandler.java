package com.sms.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.sms.response.Response;

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
	
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<?> HandleDataNotFoundException(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorResponse(HttpStatus.BAD_REQUEST.value(), "Data Not Found", ex.getMessage()));
	}

	private Response<?>createErrorResponse(int code, String description, String details) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		
		map.put("code", code+"");
		map.put("description", description);
		map.put("details", details);
//		return Optional.of(new ErrorResponse2()<?>("error", description, map).orElseThrow(() -> new ServiceException("Error creating error response")));
		return null;
//		return Optional.of(new ErrorResponse2<>("error",description,new Object()))
	}
}
//
package com.blog.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.payload.FileResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<?> FileUploadException(IOException ex)
	{
		return new ResponseEntity<>(new FileResponse(null, ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ImageFormatNotSupportException.class)
	public ResponseEntity<?> imageUploadFormatException(ImageFormatNotSupportException ex)
	{
		return new ResponseEntity<>(new FileResponse(null, ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	
}

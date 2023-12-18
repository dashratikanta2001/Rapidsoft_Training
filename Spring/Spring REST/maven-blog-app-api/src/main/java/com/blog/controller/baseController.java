package com.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/")
public class baseController {

	@GetMapping("/hi")
	public ResponseEntity<?> home()
	{
		String msg = "Hello";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}

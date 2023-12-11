package com.sms.controller;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class Home {
	
	@GetMapping("/hello")
	public ResponseEntity<?> home()
	{
		String msg = "This is home controller";
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}

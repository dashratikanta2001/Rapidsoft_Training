package com.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.UserDto;
import com.blog.response.ErrorResponse;
import com.blog.response.Response;
import com.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public ResponseEntity<?> allUsers()
	{
		Response<?> user = this.userService.findAll();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> userById(@PathVariable String email)
	{
		Response<?> user = this.userService.findByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createuser(@Valid @RequestBody UserDto userDto)
	{
		Response<?> user = this.userService.saveUser(userDto);
		
		if(user.getStatus() == HttpStatus.CREATED.value())
		{
		return new ResponseEntity<>(user, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(new ErrorResponse<>(user.getMessage(), false), HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/{email}")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto)
	{
		Response<?> user = this.userService.updateUser(userDto);
		
		if(user.getStatus() == HttpStatus.OK.value())
		{
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(new ErrorResponse<>(user.getMessage(), true), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable String email)
	{
		Response<?> response = this.userService.delete(email);
		if(response.getStatus() == HttpStatus.OK.value())
		{
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}

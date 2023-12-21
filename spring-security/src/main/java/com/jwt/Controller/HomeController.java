package com.jwt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.User;
import com.jwt.service.UserService;

@RestController
@RequestMapping("/api/")
public class HomeController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to test JWT app.";
	}
	
	@GetMapping("/success")
	public String forAll()
	{
		return "Hello User. You have logedin successfully.";
	}
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	
	@GetMapping("/allusers")
	public List<?> getAll()
	{
		return userService.getAllUsers();
	}
	
	
}

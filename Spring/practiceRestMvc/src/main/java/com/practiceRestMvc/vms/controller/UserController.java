package com.practiceRestMvc.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practiceRestMvc.vms.dto.UserDTO;
import com.practiceRestMvc.vms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<?> addNewUser(@RequestBody UserDTO userDTO)
	{
		try {
			userService.save(userDTO);
			String msg = "User created Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
//	@GetMapping("/all")
	@RequestMapping("/all")
	public ResponseEntity<?> getAll()
	{
		List<UserDTO> list = this.userService.getAll();
		
		try {
			if (list.isEmpty()) {
				String msg = "No Brands Available";
				return new ResponseEntity<String>(msg,HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<UserDTO>>(list,HttpStatus.OK);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
}

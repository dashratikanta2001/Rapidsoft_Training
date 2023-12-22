package com.blog.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.config.AppConstants;
import com.blog.response.Response;
import com.blog.services.RoleService;

@RestController
@RequestMapping("/")
public class baseController {

	@Autowired
	RoleService roleService;

	@GetMapping
	public ResponseEntity<?> home() {
		if (roleService.findByName(AppConstants.ROLE_SUPERADMIN) == null) {
			roleService.save(AppConstants.ID_SUPERADMIN, AppConstants.ROLE_SUPERADMIN);
			roleService.save(AppConstants.ID_ADMIN, AppConstants.ROLE_ADMIN);
			roleService.save(AppConstants.ID_USER, AppConstants.ROLE_USER);
		}

		Response<?> response = new Response<>();
		response.setMessage("Welcome to Maven Blog App Api.");
		response.setStatus(HttpStatus.OK.value());
		response.setData(new Date().toLocaleString());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

package com.jwt.service;

import java.util.List;

import com.jwt.entity.User;

public interface UserService {

	User createUser(User user);
	
	List<User> getAllUsers();
}

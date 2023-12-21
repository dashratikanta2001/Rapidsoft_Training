package com.jwt.dao;

import java.util.List;

import com.jwt.entity.User;

public interface UserDao {

	User save(User user);
	
	User findByEmail(String email);
	
	List<User> getAll();
	
}

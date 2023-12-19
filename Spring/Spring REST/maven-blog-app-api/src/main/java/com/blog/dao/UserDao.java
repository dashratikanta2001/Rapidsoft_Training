package com.blog.dao;

import java.util.List;
import java.util.Optional;

import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;

public interface UserDao {

	User save(User user);

	Optional<User> findById(int userId);

	Optional<User> findByEmail(String email);

	List<User> findAll();

	void delete(User user);
	

}

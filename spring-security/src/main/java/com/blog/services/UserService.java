package com.blog.services;

import com.blog.dto.UserDto;
import com.blog.response.Response;

public interface UserService {

	Response<?> saveUser(UserDto userDto);
	Response<?> findById(int userId);
 	Response<?> findByEmail(String email);
 	Response<?> delete(String email);
 	Response<?> updateUser(UserDto userDto);
 	Response<?> findAll();
}

package com.blog.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.dao.UserDao;
import com.blog.dto.UserDto;
import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.response.ErrorResponse;
import com.blog.response.Response;
import com.blog.services.UserService;

@Service
public class UserserviceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Response<?> saveUser(UserDto userdto) {
		// TODO Auto-generated method stub

		if (!userDao.findByEmail(userdto.getEmail()).isPresent()) {
			User dtoToUser = this.dtoToUser(userdto);

			User user = this.userDao.save(dtoToUser);
			if (user == null) {
				return new Response<>("User not added.", null, HttpStatus.BAD_REQUEST.value());

			}
			return new Response<>("User added successfully.", user, HttpStatus.CREATED.value());
		} else {
			return new Response<>("Email id already exist.", null, HttpStatus.BAD_REQUEST.value());
		}
	}

	@Override
	public Response<?> findById(int userId) {
		// TODO Auto-generated method stub

		User user = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		return new Response<>("User found", user, HttpStatus.OK.value());
	}

	@Override
	public Response<?> findByEmail(String email) {
		// TODO Auto-generated method stub

		User user = this.userDao.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User", "email", email));

		return new Response<>("User details", userToDto(user), HttpStatus.OK.value());
	}

	@Override
	public Response<?> delete(String email) {
		// TODO Auto-generated method stub
		User user = userDao.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "email", email));

		try {
			userDao.delete(user);
			return new Response<>("User deleted successfully.", null, HttpStatus.OK.value());
		} catch (Exception e) {
			return new Response<>("User not deleted.", null, HttpStatus.BAD_REQUEST.value());
		}
		
	}

	@Override
	public Response<?> updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<?> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private User dtoToUser(UserDto userDto) {
		return this.modelMapper.map(userDto, User.class);
	}

	private UserDto userToDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}

}

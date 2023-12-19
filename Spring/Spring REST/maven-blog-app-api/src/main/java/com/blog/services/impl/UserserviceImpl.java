package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.dao.UserDao;
import com.blog.dto.UserDto;
import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.response.Response;
import com.blog.services.UserService;

@Service
public class UserserviceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Response<?> saveUser(UserDto userDto) {
		// TODO Auto-generated method stub

		if (!userDao.findByEmail(userDto.getEmail()).isPresent()) {
			User dtoToUser = this.dtoToUser(userDto);

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
		User user = userDao.findByEmail(userDto.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("User", "email", userDto.getEmail()));

		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());


		User savedUser = userDao.save(user);

		UserDto userDto2 = modelMapper.map(savedUser, UserDto.class);

		return new Response<>("User updated Successfully", userDto2, HttpStatus.OK.value());
	}

	@Override
	public Response<?> findAll() {

		List<User> allUsers = userDao.findAll();
		List<UserDto> userDtoList = allUsers.stream().map(user -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		// TODO Auto-generated method stub
		return new Response<>("All users", userDtoList, HttpStatus.OK.value());
	}

	public User dtoToUser(UserDto userDto) {
		return this.modelMapper.map(userDto, User.class);
	}

	public UserDto userToDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}

}

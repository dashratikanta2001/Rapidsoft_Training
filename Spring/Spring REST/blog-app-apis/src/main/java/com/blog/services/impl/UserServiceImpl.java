package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.UserDao;
import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		User user = this.dtoToUser(userDto);
		
		User saveedUser = this.userDao.save(user);
		
		
		return this.userToDto(saveedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		
		User user =this.userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateUser = this.userDao.save(user);
		
		UserDto userDto1 = this.userToDto(updateUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		User user =this.userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> users = this.userDao.findAll();
		List<UserDto> userDtos = users.stream().map(user-> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user =this.userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		this.userDao.delete(user);
		
	}
	
	
	public User dtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto, User.class);
				
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		
		return user;
	}

	public UserDto userToDto(User user)
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		
		return userDto;
	}
}

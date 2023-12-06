package com.practiceRestMvc.vms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiceRestMvc.vms.dao.UserDao;
import com.practiceRestMvc.vms.dto.ConvertUser;
import com.practiceRestMvc.vms.dto.UserDTO;
import com.practiceRestMvc.vms.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void save(UserDTO userDTO)
	{
		String name = userDTO.getName();
		
		User user = ConvertUser.toUser(userDTO);
		
		this.userDao.save(user);
	}
	
	public List<UserDTO> getAll()
	{
		List<User> list = this.userDao.getAll();
		List<UserDTO> userDtoList = list.stream().map(ConvertUser::toUserDto).collect(Collectors.toList());
		
		if (!list.isEmpty()) {
			return userDtoList;
		}
		else {
			return new ArrayList<>();
		}
	}
	
	public User getById(User user)
	{
		return this.userDao.getById(user);
	}
}

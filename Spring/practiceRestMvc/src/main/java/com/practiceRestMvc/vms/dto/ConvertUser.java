package com.practiceRestMvc.vms.dto;

import com.practiceRestMvc.vms.entity.User;

public class ConvertUser {

	public static UserDTO toUserDto(User user)
	{
		UserDTO userDTO = new UserDTO();
		
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		
		return userDTO;
	}
	
	public static User toUser(UserDTO userDTO)
	{
		User user = new User();
		user.setName(userDTO.getName());
		
		return user;
	}
}

package com.blog.services.impl;

import java.util.Date; 
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.config.AppConstants;
import com.blog.dao.CredentialDao;
import com.blog.dao.RoleDao;
import com.blog.dao.UserDao;
import com.blog.dto.UserDto;
import com.blog.entity.CredentialMaster;
import com.blog.entity.Role;
import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.response.Response;
import com.blog.services.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CredentialDao credentialDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Response<?> addUserCredential(UserDto userDto) {
		// TODO Auto-generated method stub
		
		User user = userDao.findByEmail(userDto.getEmail()).orElseThrow(()-> new ResourceNotFoundException("User", "email id", userDto.getEmail()));
		
		CredentialMaster credentialMaster = new CredentialMaster();
		
		credentialMaster.setUser(user);
		credentialMaster.setUsername(user.getEmail());
		credentialMaster.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		credentialMaster.setPassword(userDto.getPassword());
		credentialMaster.setCreatedOn(new Date());
		credentialMaster.setIsActive(true);
//		
//		Role findByName = roleDao.findByName(AppConstants.ROLE_USER);
//		
//		Set<Role> roles = new HashSet<>();
//		roles.add(findByName);
		credentialMaster.setRoles(roleDao.findByName(AppConstants.ROLE_USER));
		
		Integer saveCridential = credentialDao.saveCridential(credentialMaster);
		
		if (saveCridential>0) {
			userDto.setId(user.getId());
			return new Response<>("User successfully added.", userDto, HttpStatus.CREATED.value());
		}
		
		
		return new Response<>("Try again.", userDto, HttpStatus.BAD_REQUEST.value());
	}

}

package com.blog.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.dao.CredentialDao;
import com.blog.entity.CredentialMaster;
import com.blog.entity.Role;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CredentialDao credentialDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		CredentialMaster credentialMaster = credentialDao.getUserName(username);
		
		if (credentialMaster!=null) {
			
			Role roleName = credentialMaster.getRoles();
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			authorities.add(new SimpleGrantedAuthority(roleName.getName()));
			return new User(credentialMaster.getUsername(), credentialMaster.getPassword(), authorities);
			
		}
		else {
			throw new UsernameNotFoundException("User not found");
		}
		
	}

}























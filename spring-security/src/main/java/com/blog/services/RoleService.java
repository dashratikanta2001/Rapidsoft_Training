package com.blog.services;

import com.blog.entity.Role;

public interface RoleService {

	Role findByName(String roleName);
	
	void save(Integer roleId, String roleName);
	
}

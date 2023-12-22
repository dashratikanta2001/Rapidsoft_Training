package com.blog.dao;

import com.blog.entity.Role;

public interface RoleDao {

	Role findByName(String name);
	void save(Integer roleId, String role);
}

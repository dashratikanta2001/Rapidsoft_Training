package com.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.RoleDao;
import com.blog.entity.Role;
import com.blog.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	@Override
	public Role findByName(String roleName) {
		// TODO Auto-generated method stub
		return roleDao.findByName(roleName);
	}

	@Override
	public void save(Integer roleId, String roleName) {
		// TODO Auto-generated method stub

		roleDao.save(roleId, roleName);
		
	}

}

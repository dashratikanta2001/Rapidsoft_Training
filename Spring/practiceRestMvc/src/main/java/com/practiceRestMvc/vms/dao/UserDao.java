package com.practiceRestMvc.vms.dao;

import java.util.List;

import com.practiceRestMvc.vms.entity.User;

public interface UserDao {

	public void save(User user);
	
	public void update (Integer id);
	
	public User getById(User user);
	
	public List<User> getAll();
}

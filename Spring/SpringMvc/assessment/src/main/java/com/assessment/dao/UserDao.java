package com.assessment.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.assessment.entity.User;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveUser(User user)
	{
		int id = (Integer) this.hibernateTemplate.save(user);
		
		return id;
	}
	
	public List<User> allUser()
	{
		List<User> user = this.hibernateTemplate.loadAll(User.class);
		return user;
	}
	
	public List<?> getUserDetail(String user_email)
	{
		String query = "from User where email =:userEmail";
		 List<?> user = this.hibernateTemplate.findByNamedParam(query, "userEmail", user_email);
		
//		this.hibernateTemplate.
		
		return user;
	}
}

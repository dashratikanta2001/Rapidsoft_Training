package com.jwt.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.dao.UserDao;
import com.jwt.entity.User;

@Repository
@Transactional
public class userDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(user);
		
		return user;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		System.out.println("Email = "+email);
		
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		
		User user = (User) createCriteria.add(Restrictions.eq("email", email)).uniqueResult();
		System.out.println("Inside dao user = "+user);
		return user;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		
		
		
		return criteria.list();
	}

}

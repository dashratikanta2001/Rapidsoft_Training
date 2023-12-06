package com.practiceRestMvc.vms.dao.implementation;

import java.util.List; 

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practiceRestMvc.vms.dao.UserDao;
import com.practiceRestMvc.vms.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(user);
	}

	@Override
	public void update(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getById(User user) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		User userObj = currentSession.get(User.class, user.getId());
		return userObj;
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		
		Session currentSession = this.sessionFactory.getCurrentSession();
		
		String query = "from User";
		
		List<User> list = currentSession.createQuery(query,User.class).getResultList();
		
		return list;
	}
	
	
	
}

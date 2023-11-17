package com.quiz.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.quiz.entity.User;

public class UserDao {

	private HibernateTemplate hibernateTemplate;
	
//	@Autowired
//	private SessionFactory sessionFactory;

	// Add user
	@Transactional
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
//		boolean isSave=false;
       try {
    	   System.out.println(user.getEmail() + " : " + user.getName() + " : " + user.getRollNo() + " : "
   				+ user.getUser_class() + " : " + user.getId() + user.isRechecked() + " : ");

   		this.hibernateTemplate.save(user);
//   		this.sessionFactory.getCurrentSession().save(user);
   		
//   		isSave=true;

   		return true;
       }
       catch (Exception e) {
		// TODO: handle exception
    	   e.printStackTrace();
    	   return false;
	}
		
	}

	public boolean isUserAvailable(String email) {
		// TODO Auto-generated method stub

		User user = this.hibernateTemplate.get(User.class, email);

		if (user != null) {
			return true;
		}

		return false;

	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

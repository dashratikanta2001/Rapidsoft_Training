package com.quiz.dao;

import java.util.List;

import javax.transaction.Transactional;

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
//			System.out.println(user.getEmail() + " : " + user.getName() + " : " + user.getRollNo() + " : "
//					+ user.getUser_class() + " : " + user.getId() + user.isRechecked() + " : ");

			this.hibernateTemplate.save(user);
//   		this.sessionFactory.getCurrentSession().save(user);

//   		isSave=true;

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

//	public boolean isUserAvailable(String email) {
//		// TODO Auto-generated method stub
//		String hql = "select count(*) FROM User WHERE email = :userEmail";
//		List<Long> user = (List<Long>) hibernateTemplate.findByNamedParam(hql, "userEmail", email);
//
//
//		return !user.isEmpty() && user.get(0) >0;
//
//	}
	
	public User isUserAvailable(String email) {
		// TODO Auto-generated method stub
		String query = "from User where email = :userEmail";
		List<User> user = (List<User>) this.hibernateTemplate.findByNamedParam(query, "userEmail", email);
		
		if(user.isEmpty())
		{
			return null;
		}
		else {
			return user.get(0);
		}

	}
	
	public User getUserdetails(String user_email) {
		// TODO Auto-generated method stub
		
		String query = "from User where email =:userEmail";
		return  (User) this.hibernateTemplate.findByNamedParam(query, "userEmail", user_email).get(0);
		
		
	}
	
	public List<User> getUserDetailsByClass(int userClass) {
		// TODO Auto-generated method stub
		String query = "from User where user_class=:user_class";
		
		return (List<User>) this.hibernateTemplate.findByNamedParam(query, "user_class", userClass);

	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

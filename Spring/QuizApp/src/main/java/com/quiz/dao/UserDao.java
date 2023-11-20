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
			System.out.println(user.getEmail() + " : " + user.getName() + " : " + user.getRollNo() + " : "
					+ user.getUser_class() + " : " + user.getId() + user.isRechecked() + " : ");

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

	@SuppressWarnings("deprecation")
	public boolean isUserAvailable(String email) {
		// TODO Auto-generated method stub
		String hql = "select count(*) FROM User WHERE email = :userEmail";
		List<Long> user = (List<Long>) hibernateTemplate.findByNamedParam(hql, "userEmail", email);


		return !user.isEmpty() && user.get(0) >0;

	}
	
	public User getUserdetails(String user_email) {
		// TODO Auto-generated method stub
		
		String query = "from User where email =:userEmail";
		return  (User) this.hibernateTemplate.findByNamedParam(query, "userEmail", user_email).get(0);
		
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

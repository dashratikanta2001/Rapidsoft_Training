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
	public int saveUser(User user) {
		int id = (Integer) this.hibernateTemplate.save(user);

		return id;
	}

	public List<User> allUser() {
		List<User> user = this.hibernateTemplate.loadAll(User.class);
		return user;
	}

	public List<?> getUserDetail(String user_email) {
		String query = "from User where email =:userEmail";
		List<?> user = this.hibernateTemplate.findByNamedParam(query, "userEmail", user_email);

		return user;
	}

	public List<Integer> getClassList() {
		// TODO Auto-generated method stub

		String query = "SELECT DISTINCT user_class from User";

		List<Integer> userClassList = this.hibernateTemplate.execute(session -> session
				.createQuery("SELECT DISTINCT u.user_class FROM User u", Integer.class).getResultList());

		return userClassList;
	}

	public List<User> getUserDetailsByClass(int userClass) {
		String query = "from User where user_class=:user_class";

		return (List<User>) this.hibernateTemplate.findByNamedParam(query, "user_class", userClass);

	}
}

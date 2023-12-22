package com.blog.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.dao.UserDao;
import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;

@Repository
@Transactional
public class userDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub

		try {

			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Optional<User> findById(int userId) {
		// TODO Auto-generated method stub

		User user = sessionFactory.getCurrentSession().get(User.class, userId);

		if (user == null) {
			return Optional.empty();
		}

		return Optional.of(user);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);

		criteria.add(Restrictions.eq("email", email));
		User user = (User) criteria.uniqueResult();
		if (user == null) {
			return Optional.empty();
		}

		return Optional.of(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub

		List<User> resultList = sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();

		return resultList;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);

	}

}

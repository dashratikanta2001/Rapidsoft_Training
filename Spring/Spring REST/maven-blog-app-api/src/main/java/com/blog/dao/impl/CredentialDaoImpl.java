package com.blog.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.dao.CredentialDao;
import com.blog.entity.CredentialMaster;

@Repository
@Transactional
public class CredentialDaoImpl implements CredentialDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Integer saveCridential(CredentialMaster cridentialMaster) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cridentialMaster);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public CredentialMaster getUserName(String username) {
		// TODO Auto-generated method stub
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CredentialMaster.class);
		
		criteria.add(Restrictions.eq("username", username));
		
		return (CredentialMaster) criteria.uniqueResult();
	}

	@Override
	public Integer update(CredentialMaster cridentialMaster) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().update(cridentialMaster);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}

	@Override
	public CredentialMaster getcredentialsByUser(Integer id) {
		// TODO Auto-generated method stub
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CredentialMaster.class);
		
		criteria.add(Restrictions.eq("user_id", id));
		
		return (CredentialMaster) criteria.uniqueResult();
	}

}

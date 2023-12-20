package com.blog.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.RoleDao;
import com.blog.entity.Role;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);

		criteria.add(Restrictions.eq("name", name));

		return (Role) criteria.uniqueResult();
	}

	@Override
	public void save(Integer roleId, String roleName) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		if (session.get(Role.class, roleId) == null ) {
			Role role = new Role();
//			role.setId(roleId);
			role.setName(roleName);
			session.saveOrUpdate(role);

		}
	}

}

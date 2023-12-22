package com.blog.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.dao.CategoryDao;
import com.blog.entity.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Category save(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return category;
		} catch (Exception e) {
			// TODO: handle exception
			
			return null;
		}
		
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(category);

	}

	@Override
	public Optional<Category> findById(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Category category = session.get(Category.class, categoryId);
		if (category== null) {
			return Optional.empty();
		}
		
		return Optional.of(category);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		
		List<Category> resultList = sessionFactory.getCurrentSession().createQuery("from Category", Category.class).getResultList();
		
		return resultList;
	}

	@Override
	public Optional<Category> findByTitle(String categoryTitle) {
		// TODO Auto-generated method stub
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		
		criteria.add(Restrictions.eq("categoryTitle", categoryTitle));
		
		System.out.println("Criteria present = "+criteria.uniqueResult());
		
		Category result = (Category) criteria.uniqueResult();
		
		if (result == null) {
			return Optional.empty();
		}
		
		return Optional.of(result);
	}

}

package com.blog.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.dao.PostDao;
import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;

@Repository
@Transactional
public class PostDaoImpl implements PostDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(post);
			return post;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public void delete(Post post) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().delete(post);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Optional<Post> findById(Integer postId) {
		// TODO Auto-generated method stub
		Post post = sessionFactory.getCurrentSession().get(Post.class, postId);
		
		if(post == null)
		{
			return Optional.empty();
		}
		
		return Optional.of(post);
	}

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		
		List<Post> resultList = sessionFactory.getCurrentSession().createQuery("from Post", Post.class).getResultList();
		
//		for (Post post : resultList) {
//			System.out.println(post.getUser().getPosts());
//		}
		
		for (Post post : resultList) {
			Hibernate.initialize(post.getUser().getRoles());
		}
		
		return resultList;
	}

	@Override
	public Optional<List<Post>> findBycategory(Category category) {
		// TODO Auto-generated method stub
		
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Post.class);
//		
//		criteria.add(Restrictions.eq("category", category.getClass()));
//		
//		List<Post> list = (List<Post>)criteria.list();
//		
//		System.out.println(list);
		
		return null;
	}

	@Override
	public Optional<List<Post>> findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.blog.dao.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.dao.CommentDao;
import com.blog.entity.Comment;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Comment save(Comment comment) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().save(comment);
			return comment;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(comment);
		

	}

	@Override
	public Optional<Comment> findById(Integer commentId) {
		// TODO Auto-generated method stub
		Comment comment = sessionFactory.getCurrentSession().get(Comment.class, commentId);
		
		if (comment == null) {
			return Optional.empty();			
		}
		
		return Optional.of(comment);
		
	}

}

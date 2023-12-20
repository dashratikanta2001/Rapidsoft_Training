package com.blog.dao;

import java.util.Optional;

import com.blog.entity.Comment;

public interface CommentDao {

	Comment save(Comment comment);
	
	void delete(Comment comment);
	
	Optional<Comment> findById(Integer commentId);
}

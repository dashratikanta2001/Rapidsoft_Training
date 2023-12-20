package com.blog.dao;

import java.util.List;
import java.util.Optional;

import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;

public interface PostDao {

	Post save(Post post);
	
	void delete(Post post);
	
	Optional<Post> findById(Integer postId);
	
	List<Post> findAll();
	
	Optional<List<Post>> findBycategory(Category category);
	
	Optional<List<Post>> findByUser(User user);

	Optional<List<Post>> findByTitleContaining(String keywords);
}

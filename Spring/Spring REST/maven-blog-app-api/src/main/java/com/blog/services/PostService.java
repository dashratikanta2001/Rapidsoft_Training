package com.blog.services;

import com.blog.dto.PostDto;
import com.blog.response.Response;

public interface PostService {

	
	//Create post
	Response<?> createPost(PostDto postDto, String email, Integer categoryId);
	
	
	//Update Post
	
	Response<?> updatePost(PostDto postDto, Integer postId);
	
	//deletePost
	
	Response<?> deletePost(Integer postid);
	
	//get all post
	Response<?> getAllPost();
	
	//get post By Id
	Response<?> getpostById(Integer postId);
	
	//get post by category
	Response<?> getpostBycategory(Integer categoryId);
	
	//get post by user
	Response<?> getPostByUser(Integer userId);
	
	
}

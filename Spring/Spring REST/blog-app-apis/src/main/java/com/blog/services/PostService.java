package com.blog.services;

import java.util.List;

import com.blog.entity.Post;
import com.blog.payloads.PostDto;

public interface PostService {

	
	//Create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all posts
	
	List<PostDto> getAllPost();
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all posts by category
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all post by user
	
	List<PostDto> getPostByUser(Integer userId);
	
	//search post
	
	List<PostDto> searchPost(String keyword);
}

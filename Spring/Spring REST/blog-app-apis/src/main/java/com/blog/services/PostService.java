package com.blog.services;

import java.util.List;

import com.blog.entity.Post;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {

	
	//Create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all posts
	
	PostResponse getAllPost(Integer pageNo, Integer pageSize, String sortBy,String sortDir);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all posts by category
	
	PostResponse getPostByCategory(Integer categoryId,Integer pageNo, Integer pageSize);
	
	//get all post by user
	
	PostResponse getPostByUser(Integer userId,Integer pageNo, Integer pageSize);
	
	//search post
	
	List<PostDto> searchPost(String keyword);
}

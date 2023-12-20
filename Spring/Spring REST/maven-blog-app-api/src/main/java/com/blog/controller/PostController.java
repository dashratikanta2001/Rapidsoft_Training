package com.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.PostDto;
import com.blog.response.ErrorResponse;
import com.blog.response.Response;
import com.blog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;
	
	//Create new Post
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId)
	{
		Response<?> post = postService.createPost(postDto, userId, categoryId);
		
		if (post.getStatus() == HttpStatus.CREATED.value()) {
			return new ResponseEntity<>(post, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	
	//Update the post
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<?> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		Response<?> post = postService.updatePost(postDto, postId);
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	
	//Delete the post
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<?> deletePost( @PathVariable Integer postId)
	{
		Response<?> post = postService.deletePost(postId);
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	
	//Get the post by post id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<?> getPostById( @PathVariable Integer postId)
	{
		Response<?> post = postService.getpostById(postId);
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	
	//Get all the posts
	@GetMapping("/posts")
	public ResponseEntity<?> allPosts()
	{
		Response<?> post = postService.getAllPost();
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	//Get the posts by userId
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<?> getPostByuserId(@PathVariable Integer userId)
	{
		Response<?> post = postService.getPostByUser(userId);
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	
	//Get the post by Category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<?> getPostByCategory(@PathVariable Integer categoryId)
	{
		
		Response<?> post = postService.getpostBycategory(categoryId);
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	//Search post
	
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<?> searchPostByTitle(@PathVariable String keywords)
	{
		
		Response<?> result = postService.searchPost(keywords);
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
}

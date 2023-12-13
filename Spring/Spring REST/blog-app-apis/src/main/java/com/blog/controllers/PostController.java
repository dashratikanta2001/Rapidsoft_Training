package com.blog.controllers;

import java.util.List;

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

import com.blog.payloads.ApiResponse;
import com.blog.payloads.PostDto;
import com.blog.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;

	// create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<>(createPost, HttpStatus.CREATED);
	}
	
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<?> getPostsByUser(@PathVariable Integer userId)
	{
		List<PostDto> posts = this.postService.getPostByUser(userId);
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	
	//get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<?> getPostsByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto> posts = this.postService.getPostByCategory(categoryId);
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	
	//get all posts
	@GetMapping("/posts")
	public ResponseEntity<?> getAllPosts()
	{
		List<PostDto> posts = this.postService.getAllPost();
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	
	//get all posts
	@GetMapping("/posts/{postId}")
	public ResponseEntity<?> getPostById(@PathVariable Integer postId)
	{
		PostDto postDto = this.postService.getPostById(postId);
		
		return new ResponseEntity<>(postDto, HttpStatus.OK);
	}
	
	
	//Delete post
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		
		return new ResponseEntity<>(new ApiResponse("Post is deleted successfully", true), HttpStatus.OK);

	}
	
	//Update post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<?> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable Integer postId)
	{
		PostDto post = this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
}

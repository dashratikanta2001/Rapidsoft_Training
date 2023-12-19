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
	
	@PostMapping("/user/{email}/category/{categoryId}/posts")
	public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, @PathVariable String email, @PathVariable Integer categoryId)
	{
		Response<?> post = postService.createPost(postDto, email, categoryId);
		
		if (post.getStatus() == HttpStatus.CREATED.value()) {
			return new ResponseEntity<>(post, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<?> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		Response<?> post = postService.updatePost(postDto, postId);
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<?> deletePost( @PathVariable Integer postId)
	{
		Response<?> post = postService.deletePost(postId);
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<?> getPostById( @PathVariable Integer postId)
	{
		Response<?> post = postService.getpostById(postId);
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<?> allPosts()
	{
		Response<?> post = postService.getAllPost();
		
		if (post.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(post.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	
	
}

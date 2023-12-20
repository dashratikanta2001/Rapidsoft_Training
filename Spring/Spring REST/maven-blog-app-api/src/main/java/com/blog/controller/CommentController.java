package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.CommentDto;
import com.blog.response.Response;
import com.blog.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<?> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId)
	{
		
		Response<?> comment = commentService.createComment(commentDto, postId);
		if(comment.getStatus() == HttpStatus.CREATED.value())
		{
			return new ResponseEntity<>(comment, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(comment, HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable Integer commentId)
	{
		
		Response<?> comment = commentService.deleteComment(commentId);
		if(comment.getStatus() == HttpStatus.OK.value())
		{
			return new ResponseEntity<>(comment, HttpStatus.OK);
		}
		return new ResponseEntity<>(comment, HttpStatus.BAD_REQUEST);
	}
}

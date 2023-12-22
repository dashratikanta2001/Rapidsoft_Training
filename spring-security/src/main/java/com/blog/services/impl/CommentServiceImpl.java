package com.blog.services.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.dao.CommentDao;
import com.blog.dao.PostDao;
import com.blog.dto.CommentDto;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.response.Response;
import com.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Response<?> createComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		
		Post post = postDao.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		
		Comment comment = modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		comment.setAddedDate(new Date());
		try {
			Comment savedComment = commentDao.save(comment);
			
			return new Response<>("Comment posted successfully.", modelMapper.map(savedComment, CommentDto.class), HttpStatus.CREATED.value());
		} catch (Exception e) {
			// TODO: handle exception
			return new Response<>("Comment not posted. ", null, HttpStatus.BAD_REQUEST.value());
		}
	}

	@Override
	public Response<?> deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		
		Comment comment = commentDao.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "comment id", commentId));
		try {
			commentDao.delete(comment);
			return new Response<>("Comment deleted.", null, HttpStatus.OK.value());

		} catch (Exception e) {
			// TODO: handle exception
			return new Response<>("Comment not deleted.", null, HttpStatus.BAD_REQUEST.value());

		}
		
	}

	

}

package com.blog.services;

import com.blog.dto.CommentDto;
import com.blog.response.Response;

public interface CommentService {

	Response<?> createComment(CommentDto commentDto, Integer postId);
	
	Response<?> deleteComment(Integer commentId);
}

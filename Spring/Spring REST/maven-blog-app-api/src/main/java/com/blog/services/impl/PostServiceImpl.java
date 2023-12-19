package com.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryDao;
import com.blog.dao.PostDao;
import com.blog.dao.UserDao;
import com.blog.dto.PostDto;
import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.response.Response;
import com.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Response<?> createPost(PostDto postDto, String email, Integer categoryId) {
		// TODO Auto-generated method stub

		User user = userDao.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "email", email));

		Category category = categoryDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		Post post = modelMapper.map(postDto, Post.class);

		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setCategory(category);
		post.setUser(user);

		Post newPost = postDao.save(post);

		return new Response<>("New post added sucessfully", modelMapper.map(newPost, PostDto.class),
				HttpStatus.CREATED.value());

	}

	@Override
	public Response<?> updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		
		Post post = postDao.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		
		Post UpdatedPost = postDao.save(post);
		
		return new Response<>("Post updated successfully.", UpdatedPost, HttpStatus.OK.value());
	}

	@Override
	public Response<?> deletePost(Integer postId) {
		// TODO Auto-generated method stub
		Post post = postDao.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
		
		postDao.delete(post);
		
		return new Response<>("Post deleted successfuly.", null, HttpStatus.OK.value());
	}

	@Override
	public Response<?> getAllPost() {
		// TODO Auto-generated method stub
		
		List<Post> list = postDao.findAll();
		
		
		return new Response<>("All posts", list, HttpStatus.OK.value());
	}

	@Override
	public Response<?> getpostById(Integer postId) {
		// TODO Auto-generated method stub
		
		Post post = postDao.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
		
		
		
		return new Response<>("Found post", post, HttpStatus.OK.value());
	}

	@Override
	public Response<?> getpostBycategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<?> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

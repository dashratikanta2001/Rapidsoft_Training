package com.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryDao;
import com.blog.dao.PostDao;
import com.blog.dao.UserDao;
import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.CategoryDto;
import com.blog.payloads.PostDto;
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
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub

		User user = this.userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));

		Category category = this.categoryDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);

		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setCategory(category);
		post.setUser(user);

		Post newPost = this.postDao.save(post);

		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		Post post = this.postDao.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		
		Post updatedPost = this.postDao.save(post);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		Post post = this.postDao.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		
		this.postDao.delete(post);

	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		
		List<Post> posts = this.postDao.findAll();
				
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		
		Post post = this.postDao.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		List<Post> posts = this.postDao.findByCategory(cat);

		if (posts.isEmpty()) {
			throw new ResourceNotFoundException("Post", "category id", categoryId);
		}
		
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());


		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));

		List<Post> posts = this.postDao.findByUser(user);
		
		if (posts.isEmpty()) {
			throw new ResourceNotFoundException("Post", "user id", userId);
		}
				
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());


		return postDtos;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}

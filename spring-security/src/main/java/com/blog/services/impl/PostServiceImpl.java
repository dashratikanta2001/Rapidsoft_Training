package com.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryDao;
import com.blog.dao.PostDao;
import com.blog.dao.UserDao;
import com.blog.dto.CategoryDto;
import com.blog.dto.CommentDto;
import com.blog.dto.PostDto;
import com.blog.dto.UserDto;
import com.blog.entity.Category;
import com.blog.entity.Comment;
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
	public Response<?> createPost(PostDto postDto, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub

		User user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));

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

		Post post = postDao.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());

		Post UpdatedPost = postDao.save(post);

		return new Response<>("Post updated successfully.", modelMapper.map(UpdatedPost, PostDto.class),
				HttpStatus.OK.value());
	}

	@Override
	public Response<?> deletePost(Integer postId) {
		// TODO Auto-generated method stub
		Post post = postDao.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

		postDao.delete(post);

		return new Response<>("Post deleted successfuly.", null, HttpStatus.OK.value());
	}

	@Override
	public Response<?> getAllPost() {
		// TODO Auto-generated method stub

		List<Post> list = postDao.findAll();

		List<PostDto> collect = list.stream().map((post) -> postToDto(post)).collect(Collectors.toList());

		return new Response<>("All posts", collect, HttpStatus.OK.value());
	}

	@Override
	public Response<?> getpostById(Integer postId) {
		// TODO Auto-generated method stub

		Post post = postDao.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

		PostDto postToDto = postToDto(post);

		return new Response<>("Found post", postToDto, HttpStatus.OK.value());
	}

	@Override
	public Response<?> getpostBycategory(Integer categoryId) {
		// TODO Auto-generated method stub

		Category category = categoryDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		List<Post> postList = postDao.findBycategory(category)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "category id", categoryId));

		List<PostDto> postDto = postList.stream().map((post) -> postToDto(post)).collect(Collectors.toList());
		return new Response<>("All posts", postDto, HttpStatus.OK.value());

	}

	@Override
	public Response<?> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub

		User user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));

		List<Post> postList = postDao.findByUser(user)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "user id", userId));

		List<PostDto> postDto = postList.stream().map((post) -> postToDto(post)).collect(Collectors.toList());

		return new Response<>("All posts", postDto, HttpStatus.OK.value());
	}
	
	
	@Override
	public Response<?> searchPost(String keywords) {
		// TODO Auto-generated method stub
		
		List<Post> postList = postDao.findByTitleContaining(keywords).orElseThrow(()->new ResourceNotFoundException());
		
		
		List<PostDto> postDto = postList.stream().map((post) -> postToDto(post)).collect(Collectors.toList());

		return new Response<>("Post found ", postDto, HttpStatus.OK.value());
	}

//	private Post dtoToPost(PostDto postDto)
//	{
//		return null;
//	}

	private PostDto postToDto(Post post) {
		PostDto postDto = new PostDto();

		postDto.setPostId(post.getPostId());
		postDto.setTitle(post.getTitle());
		postDto.setContent(post.getContent());
		postDto.setImageName(post.getImageName());
		postDto.setAddDate(post.getAddDate());
		postDto.setUser(modelMapper.map(post.getUser(), UserDto.class));
		postDto.setCategory(modelMapper.map(post.getCategory(), CategoryDto.class));

		Set<Comment> comments = post.getComments();

		List<CommentDto> commentDto = comments.stream().map((comment) -> modelMapper.map(comment, CommentDto.class))
				.collect(Collectors.toList());

		postDto.setComments(commentDto);

		return postDto;
	}

	
}

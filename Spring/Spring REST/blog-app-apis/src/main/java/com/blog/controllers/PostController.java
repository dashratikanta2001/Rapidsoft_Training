package com.blog.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.config.AppCnstants;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.services.FileService;
import com.blog.services.PostService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;

	// create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<>(createPost, HttpStatus.CREATED);
	}
	
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<?> getPostsByUser(@PathVariable Integer userId,
			@RequestParam(value = "pageNumber", defaultValue = AppCnstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppCnstants.PAGE_SIZE, required = false)Integer pageSize
			)
	{
		PostResponse posts = this.postService.getPostByUser(userId,pageNumber,pageSize);
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	
	//get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<?> getPostsByCategory(@PathVariable Integer categoryId,
			@RequestParam(value = "pageNumber", defaultValue = AppCnstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppCnstants.PAGE_SIZE, required = false)Integer pageSize
			)
	{
		PostResponse posts = this.postService.getPostByCategory(categoryId,pageNumber,pageSize);
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	
	//get all posts
	@GetMapping("/posts")
	public ResponseEntity<?> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = AppCnstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppCnstants.PAGE_SIZE, required = false)Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppCnstants.SORT_BY,required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppCnstants.SORT_DIR,required = false) String sortDir
			)
	{
		PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<>(postResponse, HttpStatus.OK);
	}
	
	
	//get single post
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
	
	//Search post
	
	@GetMapping("/posts/search/{keywords}")
	public List<PostDto> searchPostByTitle(@PathVariable("keywords") String keywords)
	{
		List<PostDto> result = this.postService.searchPost(keywords);
		
//		List<PostDto> result = this.postService.searchPostByParam(keywords);

		return result;
	}
	
	
	//Post image upload
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<?> uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId
			) throws IOException
	{
		PostDto postDto = this.postService.getPostById(postId);
		
		String fileName = this.fileService.uploadImage(path, image);
		
		postDto.setImageName(fileName);
		
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<>(updatePost, HttpStatus.OK);
	}
	
	//Method to serve the file.
	@GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(
			@PathVariable("imageName") String imageName,
			HttpServletResponse response
			)throws IOException
	{
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
}

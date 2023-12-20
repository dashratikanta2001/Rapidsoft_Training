package com.blog.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;

public class PostDto {

	private Integer postId;

	@NotBlank(message = "Post Title can not be blank")
	@Size(min = 4, message = "Min size of post title is 4")
	private String title;

	@NotBlank(message = "Post content can not be blank")
	@Size(min = 4, message = "Min size of post content is 4")
	private String content;

	private String imageName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date addDate;

	private UserDto user;

	private CategoryDto category;

	private List<CommentDto> comments;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDto(Integer postId, String title, String content, String imageName, Date addDate, CategoryDto category,
			UserDto user, List<CommentDto> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addDate = addDate;
		this.category = category;
		this.user = user;
		this.comments = comments;
	}

}

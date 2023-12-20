package com.blog.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentDto {

	private int id;

	private String content;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date addeddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDto(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public Date getAddeddate() {
		return addeddate;
	}

	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}

}

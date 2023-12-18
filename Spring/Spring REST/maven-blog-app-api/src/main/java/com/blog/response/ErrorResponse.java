package com.blog.response;

public class ErrorResponse<T> {

	private String message;
	private String error;
	private Integer status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public ErrorResponse(String message, String error, Integer status) {
		super();
		this.message = message;
		this.error = error;
		this.status = status;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

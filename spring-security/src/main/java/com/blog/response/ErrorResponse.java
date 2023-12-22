package com.blog.response;

public class ErrorResponse<T> {

	private String message;
	private Boolean status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ErrorResponse(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}

package com.blog.response;

public class Response <T>{

	private Integer status;
	private String message;
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(String message, Object data, Integer status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}
	
	
}

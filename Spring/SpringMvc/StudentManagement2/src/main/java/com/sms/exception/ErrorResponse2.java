package com.sms.exception;

public class ErrorResponse2<T> {

	private String status;
	private String message;
	private Object error;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	public ErrorResponse2(String status, String message, Object error) {
		super();
		this.status = status;
		this.message = message;
		this.error = error;
	}
	public ErrorResponse2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

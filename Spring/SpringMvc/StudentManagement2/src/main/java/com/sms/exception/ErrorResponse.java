package com.sms.exception;


public class ErrorResponse<T> {

	private String status;
	private boolean error;
	private int code;
	private String message;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ErrorResponse(String status, boolean error, int code, String message) {
		super();
		this.status = status;
		this.error = error;
		this.code = code;
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

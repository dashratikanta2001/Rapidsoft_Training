package com.sms.response;

public class Response<T> {

	private boolean success;
	private int code;
	private String message;
	private Object data;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Response(boolean success, int code, String message, Object data) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

}

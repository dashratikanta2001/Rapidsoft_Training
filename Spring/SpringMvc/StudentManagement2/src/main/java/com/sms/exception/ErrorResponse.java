package com.sms.exception;


public class ErrorResponse<T> {

	private String errorMessage;
	
	private int errorCode;
	
	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	

	public ErrorResponse(String errorMessage, int errorCode, boolean success) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.success = success;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

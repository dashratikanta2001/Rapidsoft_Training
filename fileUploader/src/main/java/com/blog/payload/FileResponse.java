package com.blog.payload;

public class FileResponse {

	String fileName;
	String message;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public FileResponse(String fileName, String message) {
		super();
		this.fileName = fileName;
		this.message = message;
	}
	
}

package com.blog.exception;

public class ImageFormatNotSupportException extends RuntimeException{

	String imageFormat;

	public ImageFormatNotSupportException(String imageFormat) {
		super(String.format("Invalid image format: %s", imageFormat));
		this.imageFormat = imageFormat;
	}
	
	
}

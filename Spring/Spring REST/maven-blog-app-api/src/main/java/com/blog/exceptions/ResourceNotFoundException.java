package com.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	String sfieldValue;
	int ifieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue)
	{
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		
		
		this.resourceName=resourceName;
		this.fieldName = fieldName;
		this.sfieldValue = fieldValue;
	}
	public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue)
	{
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		
		this.resourceName=resourceName;
		this.fieldName = fieldName;
		this.ifieldValue = fieldValue;
	}
	
	public ResourceNotFoundException()
	{
		super(String.format("No result found"));
	}
	
}

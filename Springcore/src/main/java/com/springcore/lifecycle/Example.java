package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {

	private String subject;

	public Example() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Example [subject=" + subject + "]";
	}
	
	@PostConstruct
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Starting method");
	}
	
	@PreDestroy
	public void end() {
		// TODO Auto-generated method stub
		System.out.println("Ending method");
	}
	
}

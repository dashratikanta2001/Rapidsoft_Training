package com.springcore.javaconfig;

import org.springframework.stereotype.Component;

//@Component


public class Student {
	
	private Samosa samosa;

	public void study()
	{
		System.out.println("Student is reading book");
		this.samosa.display();
	}

	public Student(Samosa samosa) {
		super();
		this.samosa = samosa;
	}

	public Samosa getSamosa() {
		return samosa;
	}

	public void setSamosa(Samosa samosa) {
		this.samosa = samosa;
	}
}

package com.springcore.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
//		Student student = context.getBean("student",Student.class);
//		Student student = context.getBean("getStudent",Student.class);
		Student student = context.getBean("student",Student.class);
//		Student student = context.getBean("temp",Student.class);
//		Student student = context.getBean("con",Student.class);
		
		System.out.println(student);
		student.study();
	}

}

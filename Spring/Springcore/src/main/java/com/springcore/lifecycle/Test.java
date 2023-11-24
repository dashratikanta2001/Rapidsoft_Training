package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/samosaconfig.xml");
		
//		Samosa s1 = (Samosa) context.getBean("s1");
//		System.out.println(s1);
////		
//		//Registering shutdown hook	
		context.registerShutdownHook();
//		
//		System.out.println("_______________________________");
//		
//		Pepsi p1 = (Pepsi) context.getBean("p1");
//		System.out.println(p1);
		
		Example example = (Example) context.getBean("e1");
		
		System.out.println(example);
	}

}
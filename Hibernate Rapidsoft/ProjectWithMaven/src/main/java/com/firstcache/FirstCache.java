package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.Student;

public class FirstCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//by default enabled
		Student student = session.get(Student.class, 13);
		System.out.println(student);
		System.out.println("Working Something ...");
		Student student2 = session.get(Student.class, 13);
		System.out.println(student2);
		
		System.out.println(session.contains(student2));
		
		
		session.close();
		factory.close();

	}

}

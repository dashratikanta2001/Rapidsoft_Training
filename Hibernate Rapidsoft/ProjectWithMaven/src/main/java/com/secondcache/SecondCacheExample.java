package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.Student;

public class SecondCacheExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session1 = factory.openSession();
		//first session
		
		Student student1 = session1.get(Student.class, 35);
		System.out.println(student1);
		
		
		
		session1.close();
		
		Session session2 = factory.openSession();
		//second session
		
		Student student2 = session2.get(Student.class, 35);
		System.out.println(student2);
		
		session2.close();
		
		Session session3 = factory.openSession();
		//third session
		
		Student student3 = session3.get(Student.class, 30);
		System.out.println(student3);
		
		session3.close();
		
		Session session4 = factory.openSession();
		//fourth session
		
		Student student4 = session4.get(Student.class, 35);
		System.out.println(student4);
		
		session4.close();
		
		factory.close();
	}

}

package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// get, load

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// load()
		Student student = session.load(Student.class, 101);
		System.out.println("std");
		Student student1 = session.load(Student.class, 101);
		System.out.println("std1");

		System.out.println(student.getId());
		System.out.println(student1.getName());

		// get()
		// Address ad = session.get(Address.class, 1);
		// System.out.println(ad.getStreet()+ " : "+ ad.getCity());
		//
		// Address ad1 = session.get(Address.class, 1);
		// System.out.println(ad1.getStreet()+ " : "+ ad1.getCity());
		//
		session.close();
		factory.close();
	}

}

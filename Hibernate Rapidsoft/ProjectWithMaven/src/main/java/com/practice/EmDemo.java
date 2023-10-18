package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Student student1 = new Student();
		student1.setId(104);
		student1.setName("Manajit");
		student1.setCity("CTC");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Android");
		certificate1.setDuration("2 months");
		student1.setCerti(certificate1);
		
		Student student2 = new Student();
		student2.setId(105);
		student2.setName("Soumya");
		student2.setCity("Delhi");
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("React");
		certificate2.setDuration("1.5 months");
		student2.setCerti(certificate2);
		
		
		Transaction tx = session.beginTransaction();
		
		//Object save
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		session.close();
		
		factory.close();
	}
}

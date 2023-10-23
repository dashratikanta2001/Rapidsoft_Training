package com.assignment.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		Teacher t1 = new Teacher();	
		t1.setTeacherId(1);
		t1.setTName("Teacher1");
		
		Subject s1 = new Subject();
		s1.setSubId(101);
		s1.setSubject("JDBC");
		t1.setSub(s1);
		s1.setT_id(t1);
		
		Teacher t2 = new Teacher();	
		t2.setTeacherId(2);
		t2.setTName("Teacher2");
		
		Subject s2 = new Subject();
		s2.setSubId(102);
		s2.setSubject("OOPS");
		t2.setSub(s2);
		s2.setT_id(t2);
		
		s.save(t1);
		s.save(t2);
		
		tx.commit();
		
		System.out.println("Teacher Data: ");
		
		Teacher t = s.get(Teacher.class, 1);
		System.out.println("Teacher Name: "+ t.getTName());
		System.out.println("Subject: "+t.getSub().getSubject());
		
		System.out.println("Subject Data: ");
		Subject sub = s.get(Subject.class, 101);
		System.out.println("Subject Name: "+sub.getSubject());
		System.out.println("Teacher: "+sub.getT_id().getTName());	
		
		s.close();
		factory.close();
	}

}

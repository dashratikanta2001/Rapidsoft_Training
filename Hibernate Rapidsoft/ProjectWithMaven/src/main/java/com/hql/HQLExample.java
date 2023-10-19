package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.Student;

public class HQLExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();	 
		
		//HQL --- select query
		//Syntax:
		//
//		String query="from Student where city='BBSR'";
		String query="from Student where city=:x";
//		String query="from Student as s where s.city=:x and s.name=:n";
		
		
		Query q= s.createQuery(query);
		q.setParameter("x", "BBSR");
//		q.setParameter("n", "Akhila");
		//single result -(unique)
//		q.uniqueResult();
		//multiple -(list)
		
		List<Student> list= q.list();
		
		for(Student std:list)
		{
			System.out.println(std.getName()+" : "+std.getCerti().getCourse());
		}
		
		System.out.println("________________________________________________");
		
		Transaction tx = s.beginTransaction();
		
//		//Delete Query
//		Query q2=s.createQuery("delete from Student s where s.city=:c");
//		q2.setParameter("c", "ABC");
//		
//		int r=q2.executeUpdate();
//		System.out.println("Deleted:"+r);
		
//		//Update Query
//		Query q2= s.createQuery("update Student set city=:c where name=:n");
//		q2.setParameter("c", "Delhi");
//		q2.setParameter("n", "Akhila");
//		int r = q2.executeUpdate();
//		System.out.println(r+" Updated");
		
		tx.commit();
		
		//How to Execute Join Query
		Query q3 = s.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answers as a");
		List<Object []> list3= q3.getResultList();
		
		for(Object[] arr:list3)
		{
			System.out.println(Arrays.toString(arr));
		}
		
		
		s.close();
		factory.close();
	}
}

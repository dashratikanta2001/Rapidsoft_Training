package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.practice.Student;

public class HQLPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

//		Query query = s.createQuery("from Student");
		Query<Student> query = s.createQuery("from Student", Student.class);

		// Implementing pagination using hibernate

		query.setFirstResult(0);
		query.setMaxResults(5);

		List<Student> list = query.list();
		for (Student st : list) {
			System.out.println(st.getId() + " : " + st.getName() + " : " + st.getCity());
		}

		s.close();
		factory.close();
	}

}

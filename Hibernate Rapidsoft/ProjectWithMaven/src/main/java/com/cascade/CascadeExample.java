package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Question q1 = new Question();
		q1.setQuestionId(5681);
		q1.setQuestion("What is Swing Framework ?");
		
		Answer a1 = new Answer(23421,"Use for development");
		Answer a2 = new Answer(2511,"Swing second Answer");
		Answer a3 = new Answer(3511,"Swing Third Answer");
		
		
		List<Answer> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		Transaction tx = s.beginTransaction();
		s.save(q1);
//		s.save(a1);
//		s.save(a2);
//		s.save(a3);
		
		tx.commit();
		s.close();
		factory.close();
		
		
	}

}

package com.map;

//import java.util.ArrayList;  
//import java.util.List;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		/*
		 * //One to One
		 * 
		 * // Creating Question1 Question q1 = new Question(); q1.setQuestionId(1212);
		 * q1.setQuestion("What is java");
		 * 
		 * // Creating Answer1 Answer ans1 = new Answer(); ans1.setAnswerId(343);
		 * ans1.setAnswer("Java is programming language"); ans1.setQuestion(q1);
		 * q1.setAnswers(ans1);
		 * 
		 * // Creating Question2 Question q2 = new Question(); q2.setQuestionId(242);
		 * q2.setQuestion("What is collection Framework");
		 * 
		 * // Creating Answer Answer ans2 = new Answer(); ans2.setAnswerId(344);
		 * ans2.setAnswer("API to work with objects in java"); ans2.setQuestion(q2);
		 * q2.setAnswers(ans2);
		 * 
		 * // session Session s = factory.openSession(); Transaction tx =
		 * s.beginTransaction();
		 * 
		 * // save s.save(q1); s.save(q2); s.save(ans1); s.save(ans2);
		 * 
		 * tx.commit();
		 * 
		 * //Fetching Question newQ= s.get(Question.class, 242);
		 * System.out.println(newQ.getQuestion());
		 * System.out.println(newQ.getAnswer().getAnswer());
		 * 
		 */

		/*
		// One to Many

		// Creating Question
		Question q = new Question();
		q.setQuestionId(121);
		q.setQuestion("What is java ?");

		// Creating Answer1
		Answer ans = new Answer();
		ans.setAnswerId(343);
		ans.setAnswer("java is programming language");
		ans.setQuestion(q);

		// Creating Answer1
		Answer ans1 = new Answer();
		ans1.setAnswerId(33);
		ans1.setAnswer("With the help of java we can create softwares");
		ans1.setQuestion(q);

		// Creating Answer1
		Answer ans2 = new Answer();
		ans2.setAnswerId(363);
		ans2.setAnswer("java has different types of frameworks");
		ans2.setQuestion(q);

		List<Answer> list = new ArrayList<>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		q.setAnswers(list);
		
		*/

		// session
		Session s = factory.openSession();
//		Transaction tx = s.beginTransaction();

//		// save
//		s.save(q);
//		s.save(ans);
//		s.save(ans1);
//		s.save(ans2);
//		tx.commit();
		
		//Fetching.....
		
//		Question q1 = s.get(Question.class, 1213);
//		System.out.println(q1.getQuestion());
//		
//		for(Answer a: q1.getAnswers())
//		{
//			System.out.println(a.getAnswer());
//		}
//		
//		System.out.println("Ans--------------------");
//		Answer a1 = s.get(Answer.class, 363);
//		System.out.println(a1.getAnswer());
//		System.out.println(a1.getQuestion().getQuestion());
		
		Question q = s.get(Question.class, 1212);
		
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		//lazy
		System.out.println(q.getAnswers().size());
		
		
		s.close();

		factory.close();
	}

}

package com.dao.questionDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.questionEntity.Question;

public class QuestionDAO {
	public void addQuestion(String question) {
		// TODO Auto-generated method stub
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session session = f.openSession();

		Transaction tx = session.beginTransaction();

		try {
			Question q = new Question();
			q.setQuestion(question);
			session.save(q);
			System.out.println("This Question ID = "+ q.getId());
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			f.close();
		}

	}

}

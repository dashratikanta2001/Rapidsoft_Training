package com.questionAnswerdao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.optionEntity.Option;
import com.entity.questionEntity.Question;

public class QaDAO {
	
	public void addQuestionAnswer(String question, Option answers) {
		// TODO Auto-generated method stub
		
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session session = f.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Question q = new Question();
			q.setQuestion(question);
			List<Option> ans = new ArrayList<Option>();
			ans.add(answers);
			
						
//			q.setOption(ans);
			q.setOption(ans);
			
			session.save(q);
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			session.close();
			f.close();
		}

	}

}

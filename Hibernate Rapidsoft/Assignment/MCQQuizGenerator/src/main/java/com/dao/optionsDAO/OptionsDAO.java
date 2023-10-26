package com.dao.optionsDAO;


import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.optionEntity.Option;
import com.entity.questionEntity.Question;

public class OptionsDAO {
	@SuppressWarnings("unused")
	public void addOption(int questionId, String option) {
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session session = f.openSession();
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		
			
			Question q = session.load(Question.class, questionId);
			String checkavailable = q.getQuestion();
			
			Option op = new Option();
			op.setOption(option);	
			op.setQuestion(q);
			
			session.save(op);
			tx.commit();
			
			session.close();
			f.close();

	}
	
	public Map<Integer, String> getOptions(int qid) {
		// TODO Auto-generated method stub
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session session = f.openSession();
		Map<Integer, String> optionMap = new HashMap<>();
		try {
			Question q = session.get(Question.class, qid);
					
			for(Option op:q.getOption())
			{
				optionMap.put(op.getId(), op.getOption());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			session.close();
			f.close();
		}
		
		return optionMap;
		

	}

}

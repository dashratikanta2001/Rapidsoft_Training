package com.dao.optionsDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.optionEntity.Option;
import com.entity.questionEntity.Question;

public class OptionsDAO {
	SessionFactory f = new Configuration().configure().buildSessionFactory();
	Session session = f.openSession();
	public void addOption(int questionId, String option) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		try {
			
			Question q = session.get(Question.class, questionId);
			
			Option op = new Option();
			op.setOption(option);	
			op.setQuestion(q);
//			q.get
			System.out.println("This is question id:" +q.getId());
			
			session.save(op);
			tx.commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: \n\n\n\n\n\n"+e+"\n\n\n");
		}
		finally {
			session.close();
			f.close();
		}

	}
	
	public void getOptions(int qid) {
		// TODO Auto-generated method stub
		
		Question q = session.get(Question.class, qid);
		int i=1;
		
		for(Option op:q.getOption())
		{
			System.out.println(i++ +". "+ op.getOption());
		}
		

	}

}

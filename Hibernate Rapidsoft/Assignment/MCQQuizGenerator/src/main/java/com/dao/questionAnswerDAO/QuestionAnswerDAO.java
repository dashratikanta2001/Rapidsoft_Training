package com.dao.questionAnswerDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dao.optionsDAO.OptionsDAO;
import com.entity.optionEntity.Option;
import com.entity.questionAnswerEntity.QuestionAnswer;

public class QuestionAnswerDAO {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	SessionFactory f = new Configuration().configure().buildSessionFactory();
	Session session = f.openSession();
	Transaction tx = session.beginTransaction();
	
	public void setAnswer(int qId) {
		// TODO Auto-generated method stub
		
		try {
			showOptions(qId);
			System.out.println("Enter Option ID to set as answer: ");
			int optionId = Integer.parseInt(br.readLine());
			
			Option op = new Option();
			op.getId();
			
//			QuestionAnswer qa = new QuestionAnswer();
			
//			qa.setOption();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  void showOptions(int qId) {
		// TODO Auto-generated method stub
		
		OptionsDAO op = new OptionsDAO();
		op.getOptions(qId);

	}

}

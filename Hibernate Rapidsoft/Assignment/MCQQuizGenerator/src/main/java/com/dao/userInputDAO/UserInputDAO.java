package com.dao.userInputDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.userInputEntity.UserInput;
import com.main.App;

public class UserInputDAO {

	public void saveAnswer(UserInput input) {
		// TODO Auto-generated method stub
		SessionFactory factory = App.factory;
		Session s = factory.openSession();	
		Transaction tx = s.beginTransaction();
		
		s.save(input);
		tx.commit();

	}
	
	public boolean ifUserAnswerExist(int userId) {
		// TODO Auto-generated method stub
		SessionFactory factory = App.factory;
		Session s = factory.openSession();	
		
		String query = "from UserInput";
		
		List<UserInput> list = s.createQuery(query,UserInput.class).getResultList();
		
		for (UserInput input : list) {
			
			if(input.getUser().getUser_id()==userId)
			{
				return true;
			}

		}
		return false;
		
		

	}
	
}

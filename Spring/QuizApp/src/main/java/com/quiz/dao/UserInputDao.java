package com.quiz.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.quiz.entity.UserInput;

public class UserInputDao {
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void saveAnswer(UserInput userInput) {
		// TODO Auto-generated method stub
		
		this.hibernateTemplate.save(userInput);

	}
	
	public List<UserInput> getUserInputById(int u_id) {
		// TODO Auto-generated method stub

		String query = "from UserInput where user_id=:userInputId";
		
		List<UserInput> userInput = (List<UserInput>) this.hibernateTemplate.findByNamedParam(query, "userInputId", u_id);
		
		
		return userInput;
	}
	
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

package com.assessment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.assessment.entity.UserInput;

@Repository
public class UserInputDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public boolean saveAnswers(List<UserInput> userInputList) {
		for (UserInput userInput : userInputList) {
			this.hibernateTemplate.save(userInput);
		}
		return true;
	}

	public List<UserInput> getUserInputById(int u_id) {
		String query = "from UserInput where user_id=:userInputId";
		List<UserInput> userInput = (List<UserInput>) this.hibernateTemplate.findByNamedParam(query, "userInputId",u_id);

		return userInput;
	}
}

package com.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.dao.UserInputDao;
import com.assessment.entity.UserInput;

@Service
public class UserInputService {

	@Autowired
	private UserInputDao userInputDao;
	
	public boolean saveAnswers(List<UserInput> inputs)
	{
		return userInputDao.saveAnswers(inputs);
	}
	
	public List<UserInput> getUserInputById(int u_id) {
		// TODO Auto-generated method stub
		
		return userInputDao.getUserInputById(u_id);

	}
}

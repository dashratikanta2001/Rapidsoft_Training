package com.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.dao.OptionDao;
import com.assessment.entity.Option;
import com.assessment.entity.Question;

@Service
public class OptionService {

	@Autowired
	private OptionDao optionDao;
	
	public List<Option> showOptions(Question question)
	{
		List<Option> showOptions = optionDao.showOptions(question.getQuestion_id());
		
		return showOptions;
	}

	public Option showAnswer(int questionId) {
		// TODO Auto-generated method stub
		return optionDao.showAnswer(questionId);
	}
	
}

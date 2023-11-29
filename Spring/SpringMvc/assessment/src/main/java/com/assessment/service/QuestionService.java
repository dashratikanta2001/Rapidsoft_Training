package com.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.dao.QuestionDao;
import com.assessment.entity.Question;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionDao questionDao;
	
	public List<Question> showQuestion(int class_id, int test_no)
	{
		return questionDao.showQuestion(class_id, test_no);
	}

}

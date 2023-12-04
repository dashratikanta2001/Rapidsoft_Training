package com.assessment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.assessment.entity.Option;
import com.assessment.entity.Question;

@Repository
public class OptionDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public List<Option> showOptions(int q_id)
	{
		List<Option> options = new ArrayList<>();
		Question q = this.hibernateTemplate.get(Question.class, q_id);
		Hibernate.initialize(q);
		for (Option option : q.getOption()) {
			options.add(option);
		}
		
		return options;
		
	}

	@Transactional
	public Option showAnswer(int questionId) {
		// TODO Auto-generated method stub
		String query = "from Option where question_id=: que_id and isAnswer = true";

		Option op=new Option() ;
		 List<Option> ans = (List<Option>) this.hibernateTemplate.findByNamedParam(query, "que_id", questionId);
		 
		 for (Option option : ans) {
			op=option;
		}
		 
		 
		return op;
	}

	@Transactional
	public void addOption(Integer questionId, String option, boolean isAnswer) {
		// TODO Auto-generated method stub
		Question question = this.hibernateTemplate.get(Question.class, questionId);
		Option op = new Option();
		op.setAnswer(isAnswer);
		op.setQ_option(option);
		op.setQuestion(question);
		
		this.hibernateTemplate.saveOrUpdate(op);
		
	}
}

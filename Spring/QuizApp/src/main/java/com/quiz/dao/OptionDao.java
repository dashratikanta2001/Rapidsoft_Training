package com.quiz.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.quiz.App;
import com.quiz.entity.Option;
import com.quiz.entity.Question;

public class OptionDao {
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void addOption(int questionId, String option, boolean isAnswer) {
		// TODO Auto-generated method stub

//		System.out.println("Qid= "+questionId+" | is answer= "+isAnswer+" | option= "+option);

		Question q = this.hibernateTemplate.get(Question.class, questionId);

		Option op = new Option();

		op.setAnswer(isAnswer);
		op.setQ_option(option);
		op.setQuestion(q);

		this.hibernateTemplate.saveOrUpdate(op);
		;

	}

	public boolean checkOptionAvailable(int questionId) {
		// TODO Auto-generated method stub

		String query = "select count(*) from Option where question_id =:q_id";

		List<Long> optionCount = (List<Long>) this.hibernateTemplate.findByNamedParam(query, "q_id", questionId);

//		System.out.println(optionCount);

		return optionCount.get(0) >= 4;

	}

	@Transactional
	public List<Option> showOptions(int q_id) {
		// TODO Auto-generated method stub

		List<Option> options = new ArrayList<>();

		Question q = this.hibernateTemplate.get(Question.class, q_id);
		Hibernate.initialize(q);
		for (Option option : q.getOption()) {
			options.add(option);
		}

		return options;

	}

//	@Transactional
	public Option showAnswer(int q_id) {
		// TODO Auto-generated method stub


		String query = "from Option where question_id=: que_id and isAnswer = true";

		 List<Option> ans = (List<Option>) this.hibernateTemplate.findByNamedParam(query, "que_id", q_id);
		return ans.get(0);
		
//		Option ans= new Option();
//		Question q = this.hibernateTemplate.get(Question.class, q_id);
//		Hibernate.initialize(q);
//		for (Option answer : q.getOption()) {
//
//			if (answer.isAnswer() == true) {
//
//				ans= answer;
//			}
//		}
//		System.out.println("Answer = = = = "+ans);
//		 System.out.println();
//		 return ans;


	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}

package com.quiz.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.quiz.entity.Option;
import com.quiz.entity.Question;

public class QuestionDao {
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void addQuestion(int classId,int  testNo,String question) {
		// TODO Auto-generated method stub
		
		Question q = new Question();
		
		q.setTest_id(testNo);
		q.setClass_id(classId);
		q.setQuestion(question);
		
		this.hibernateTemplate.save(q);
		
	}
	
	public HashMap<Integer, String> showQuestionById(int classId, int testId) {
		// TODO Auto-generated method stub
		String query="from Question where class_id=:c_id and test_no=:t_id";
		
//		List<String> param=new ArrayList<>();
//		param.addAll(classId);
//		param.add(testId);
//		param.add(questionId);
		
		List<Question> QList = (List<Question>) this.hibernateTemplate.findByNamedParam(query, new String[] {"c_id","t_id"}, new Object[] {classId,testId});
		
		
//		System.out.println("Question = "+question);
		HashMap<Integer, String> question = new HashMap<>();
		
		for (Question question2 : QList) {
			
			question.put(question2.getQuestion_id(), question2.getQuestion());
		}
		
//		System.out.println(question);
		
		return question;
	}
	
	
	public List<Question> showQuestion(int class_id, int test_no) {
		// TODO Auto-generated method stub
		
		String query = "from Question where class_id=: c_id and test_no =: t_id";
		return (List<Question>) this.hibernateTemplate.findByNamedParam(query, new String[] {"c_id","t_id" }, new Object[] {class_id,test_no});
				
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

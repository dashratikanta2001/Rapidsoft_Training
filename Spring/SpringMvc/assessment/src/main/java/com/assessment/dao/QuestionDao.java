package com.assessment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.assessment.entity.Question;

@Repository
public class QuestionDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Question> showQuestion(int class_id, int test_no) {
		// TODO Auto-generated method stub
		String query = "from Question where class_id=: c_id and test_no =: t_id";
		return (List<Question>) this.hibernateTemplate.findByNamedParam(query, new String[] {"c_id","t_id" }, new Object[] {class_id,test_no});
		

	}
	
}

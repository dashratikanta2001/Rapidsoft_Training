package com.assessment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.assessment.entity.TestNo;
import com.assessment.entity.User;

@Repository
public class TestDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	public boolean testGiven(int user_id, int test_id)
	{
		String query = "from TestNo where user_id=:userId and test_no=:testId";
		List<?> list = this.hibernateTemplate.findByNamedParam(query, new String[] {"userId","testId"},new Object[] {user_id,test_id});
		
		return !list.isEmpty();
	}
	
	@Transactional
	public void setTestDetails(int test_no, int user_id) {
		// TODO Auto-generated method stub
		
		TestNo t = new TestNo();
		t.setTest_no(test_no);
		t.setUser(new User(user_id));
		this.hibernateTemplate.save(t);

	}
}

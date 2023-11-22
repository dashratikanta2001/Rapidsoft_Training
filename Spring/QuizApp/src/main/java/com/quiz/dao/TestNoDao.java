package com.quiz.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.quiz.entity.TestNo;
import com.quiz.entity.User;
import com.quiz.entity.UserInput;

public class TestNoDao {

	private HibernateTemplate hibernateTemplate;
	
	public List<Integer> getAvailableTest(int user_id) {
		// TODO Auto-generated method stub
		
		String query = "from TestNo where user_id=:userId";
		List<Integer> test = new ArrayList<>();
		
		List<TestNo> testNoList = (List<TestNo>) this.hibernateTemplate.findByNamedParam(query, "userId", user_id);
		
		for (TestNo testNo : testNoList) {
			test.add(testNo.getTest_no());
		}
		return test;

	}
	
	@Transactional
	public void setTestDetails(int test_no,User user ) {
		// TODO Auto-generated method stub
		
		TestNo t = new TestNo();
		t.setTest_no(test_no);
		t.setUser(user);
		
		this.hibernateTemplate.save(t);

	}
	
	
	public TestNo isRechecked(int userId, int testNo) {
		// TODO Auto-generated method stub
		
		String query = "from TestNo where user_id =: user_id and test_no =:test_no and isRechecked=false";
		
		 List<TestNo> rechecked = (List<TestNo>) this.hibernateTemplate.findByNamedParam(query, new String[] {"user_id", "test_no"}, new Object[] {userId, testNo});
		
		 if (rechecked.isEmpty()) {
			return null;
		}
		 else {
			return rechecked.get(0);
		}
		 
	}
	
	@Transactional
	public void setRechecked(TestNo rechecked) {
		// TODO Auto-generated method stub
		rechecked.setRechecked(true);
		
		this.hibernateTemplate.update(rechecked);
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

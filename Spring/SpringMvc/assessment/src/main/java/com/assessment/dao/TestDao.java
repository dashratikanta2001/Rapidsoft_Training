package com.assessment.dao;

import java.util.Collections;
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
	
	public List<Integer> getTestDetails(int user_id)
	{
		String query = "select test_no from TestNo where user_id=:userId";
		List<Integer> testNo = (List<Integer>) this.hibernateTemplate.findByNamedParam(query, "userId", user_id);
		Collections.sort(testNo);
		
		return testNo;
	}
	
	public TestNo isRechecked(int userId, int testNo)
	{
		String query = "from TestNo where user_id =: user_id and test_no =:test_no and isRechecked=false";
		
		 List<TestNo> rechecked = (List<TestNo>) this.hibernateTemplate.findByNamedParam(query, new String[] {"user_id", "test_no"}, new Object[] {userId, testNo});
		
		 if (rechecked.isEmpty()) {
			return null;
		}
		 else {
			return rechecked.get(0);
		}
	}
	
	
	public List<TestNo> getAllRecheckList() {
		// TODO Auto-generated method stub
		String query = " from TestNo where isRechecked=:check";
		
		List<TestNo> userList = (List<TestNo>) this.hibernateTemplate.findByNamedParam(query, "check", true);
		
		return userList;
	}
	
	@Transactional
	public void setRechecked(TestNo rechecked) {
		// TODO Auto-generated method stub
		rechecked.setRechecked(true);
		
		this.hibernateTemplate.update(rechecked);
		
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

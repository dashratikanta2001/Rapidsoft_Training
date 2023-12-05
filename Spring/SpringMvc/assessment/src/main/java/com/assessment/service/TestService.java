package com.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.dao.TestDao;
import com.assessment.entity.TestNo;
import com.assessment.entity.User;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	public boolean isTestGiven(int user_id, int test_id)
	{
		return testDao.testGiven(user_id, test_id);
	}
	
	public List<Integer> getTestDetails(int user_id)
	{
		return testDao.getTestDetails(user_id);
		
	}
	
	public TestNo isRechecked(int userId, int testNo)
	{
		return testDao.isRechecked(userId, testNo);
	}
	
	public void setRechecked(TestNo rechecked) {
		testDao.setRechecked(rechecked);
		
	}
	
	public List<TestNo> getAllRecheckList()
	{
		 return testDao.getAllRecheckList();
	}
	
	public void setTestDetails(int test_no, int user_id)
	{
		testDao.setTestDetails(test_no, user_id);
	}
}

package com.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.dao.UserDao;
import com.assessment.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public int createUser(User user) {
		return this.userDao.saveUser(user);
	}

	public List<User> allUser() {
		List<User> user = this.userDao.allUser();
		return user;
	}

	public User getUserDetails(String email) {
		List<?> userDetail = this.userDao.getUserDetail(email);
		
		if (!userDetail.isEmpty())
		{
			return (User) userDetail.get(0);
		}
		else {
			return null;
		}
	}
	
	
	public List<Integer> getClassList() {
		// TODO Auto-generated method stub
		return this.userDao.getClassList();
	}

	public List<User> getUserDetailsByClass(int userClass) {
		// TODO Auto-generated method stub
		return userDao.getUserDetailsByClass(userClass);
	}
}

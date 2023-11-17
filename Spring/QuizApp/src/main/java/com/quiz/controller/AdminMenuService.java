package com.quiz.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.quiz.App;
import com.quiz.dao.UserDao;
import com.quiz.entity.User;

public class AdminMenuService {

	UserDao userDao = App.context.getBean("userDao", UserDao.class);
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void addUser() {
		// TODO Auto-generated method stub
		User user = new User();

		try {
			System.out.println("Enter email id:");
			user.setEmail(br.readLine());
			
			System.out.println("Enter name:");
			user.setName(br.readLine());
			
			System.out.println("Enter roll No:");
			user.setRollNo(br.readLine());
			
			boolean checker = true;
			
			while (checker) {
				System.out.println("Enter the menu number to select class of the user: ");
				System.out.println("1. Class 8th");
				System.out.println("2. Class 9th");
				System.out.println("3. Class 10th");
				
				switch (Integer.parseInt(br.readLine())) {
				case 1:
					user.setUser_class(8);
					checker = false;
					break;
				case 2:
					user.setUser_class(9);
					checker = false;
					break;
				case 3:
					user.setUser_class(10);
					checker = false;
					break;
				}
			}
			
			
			if( userDao.addUser(user))
				System.out.println("User added successfully!!!!!");
			else
				System.out.println("User does not added.........");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Invalid cridential please try again");
			e.printStackTrace();
		}


	}
	
	public void checkUserAvailable() {
		// TODO Auto-generated method stub
		
		try {
			if(userDao.isUserAvailable(br.readLine()))
				System.out.println("Available ");
			else {
				System.out.println("Not available");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package com.quiz.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

import com.quiz.App;
import com.quiz.dao.OptionDao;
import com.quiz.dao.QuestionDao;
import com.quiz.dao.UserDao;
import com.quiz.entity.User;

public class AdminMenuService {

	UserDao userDao = App.context.getBean("userDao", UserDao.class);
	QuestionDao questionDao = App.context.getBean("questionDao", QuestionDao.class);
	OptionDao optionDao = App.context.getBean("optionDao", OptionDao.class);

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

			if (userDao.addUser(user))
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
			if (userDao.isUserAvailable(br.readLine()))
				System.out.println("Available ");
			else {
				System.out.println("Not available");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setQuestion() {
		// TODO Auto-generated method stub

		char checker = 'N';
		String question = "";
		int classId;

		try {
			System.out.println("Enter class");
			classId = Integer.parseInt(br.readLine());

			System.out.println("Enter test number");
			int testNo = Integer.parseInt(br.readLine());

			do {
				System.out.println("Enter Question: ");
				question = br.readLine();

				questionDao.addQuestion(classId, testNo, question);

				System.out.println("Do you want to add more question? | press Y/y to continue....");
				checker = br.readLine().charAt(0);
			} while (checker == 'Y' || checker == 'y');

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setOption() {
		// TODO Auto-generated method stub
		try {

			String input = "";
			System.out.println("Enter Class:");
			int classId = Integer.parseInt(br.readLine());
//			do {
			System.out.println("Enter Test No");
			int testId = Integer.parseInt(br.readLine());
			HashMap<Integer, String> questions = questionDao.showQuestionById(classId, testId);

			for (Entry<Integer, String> question : questions.entrySet()) {

				System.out.println(question.getValue());

				if (optionDao.checkOptionAvailable(question.getKey())) {

					System.out.println("Option already set.");
				} else {

					boolean optionset = false;
					for (int i = 1; i <= 4; i++) {

						boolean isAnswer = false;
						System.out.println("Enter option no " + i);

						String option = br.readLine();
						if (!optionset) {
							System.out.println("Set to answer ? (y/n)");
							isAnswer = br.readLine().equalsIgnoreCase("y");
							if (isAnswer)
								optionset = true;
						}
						optionDao.addOption(question.getKey(), option, isAnswer);
					}
				}

				System.out.println("do you want to continue ? y");
				input = br.readLine();
				if (!input.equalsIgnoreCase("y")) {
					break;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

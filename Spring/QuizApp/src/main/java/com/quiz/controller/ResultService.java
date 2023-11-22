package com.quiz.controller;

import java.util.List;

import com.quiz.App;
import com.quiz.dao.OptionDao;
import com.quiz.dao.QuestionDao;
import com.quiz.dao.UserDao;
import com.quiz.dao.UserInputDao;
import com.quiz.entity.Option;
import com.quiz.entity.Question;
import com.quiz.entity.User;
import com.quiz.entity.UserInput;

public class ResultService {

	UserDao userDao = App.context.getBean("userDao", UserDao.class);
	QuestionDao questionDao = App.context.getBean("questionDao", QuestionDao.class);
	OptionDao optionDao = App.context.getBean("optionDao", OptionDao.class);
	UserInputDao userInputDao = App.context.getBean("userInputDao", UserInputDao.class);

	public void showResultByEmail(User user, int test_no) {
		// TODO Auto-generated method stub
		int mark = 0;

//		User user = userDao.getUserdetails(email);
		int userId = user.getId();

		int userClass = user.getUser_class();

		List<Question> questionList = questionDao.showQuestion(userClass, test_no);
		
		int totalMark = questionList.size();

		List<UserInput> userInput = userInputDao.getUserInputById(userId);

		for (UserInput userAnswer : userInput) {

			for (Question question : questionList) {
				int question_id = question.getQuestion_id();

				Option ans = optionDao.showAnswer(question_id);

				if (userAnswer.getOption().getOption_id() == ans.getOption_id()) {
					mark++;
				}

			}
		}

//		String ansQuery = "from q_options where ";
		showUserMarkDetails(user, mark, totalMark);

//		System.out.println("Mark = " + mark);

	}

	public void showMarkByClass(int user_class, int test_no) {
		// TODO Auto-generated method stub

//		int test_no=1;
		List<User> userDetails = userDao.getUserDetailsByClass(user_class);

		List<Question> questionList = questionDao.showQuestion(user_class, test_no);
		
		int totalMark = questionList.size();

		if (!questionList.isEmpty()) {

			for (User user : userDetails) {
				int mark = 0;

				List<UserInput> userInput = userInputDao.getUserInputById(user.getId());

				if (!userInput.isEmpty()) {

					for (UserInput userAnswer : userInput) {

						for (Question question : questionList) {
							int question_id = question.getQuestion_id();

							Option ans = optionDao.showAnswer(question_id);

							if (userAnswer.getOption().getOption_id() == ans.getOption_id()) {
								mark++;
							}

						}
					}

					showUserMarkDetails(user, mark, totalMark);
				} else {
					System.out.println("_____________________________________");
					System.out.println("Roll No: " + user.getRollNo());
					System.out.println("Name: " + user.getName());
					System.out.println("Quiz not attempted");
					System.out.println("_____________________________________");
				}

			}
		} else {
			System.out.println("Question is not set yet for class " + user_class + " test " + test_no);
		}

	}

	private void showUserMarkDetails(User user, int mark, int totalMark) {
		// TODO Auto-generated method stub
		
		String grade="";
		
		if(mark/totalMark >= 0.5)
		{
			grade="Pass";
		}
		else {
			grade="Fail";
		}
		
		
		System.out.println("_____________________________________");
		System.out.println("Roll No: " + user.getRollNo());
		System.out.println("Name: " + user.getName());
		System.out.println("Mark: " + mark);
		System.out.println("Status: "+grade);
		System.out.println("_____________________________________");

	}
	
	

}

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

	public void showResultByEmail(String email, int test_no) {
		// TODO Auto-generated method stub
		int mark = 0;

		User user = userDao.getUserdetails(email);
		int userId = user.getId();

		int userClass = user.getUser_class();

		List<Question> questionList = questionDao.showQuestion(userClass, test_no);

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

		System.out.println("Mark = " + mark);

	}

}

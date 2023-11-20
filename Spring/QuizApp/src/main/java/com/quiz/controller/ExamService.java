package com.quiz.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
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

public class ExamService {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	UserDao userDao = App.context.getBean("userDao", UserDao.class);
	QuestionDao questionDao = App.context.getBean("questionDao", QuestionDao.class);
	OptionDao optionDao = App.context.getBean("optionDao", OptionDao.class);
	UserInputDao userinputDao = App.context.getBean("userInputDao", UserInputDao.class);

	public void startExam() {
		// TODO Auto-generated method stub

		try {

			System.out.println("Enter email id:");
			String email = br.readLine();

			if (userDao.isUserAvailable(email)) {
				System.out.println("User is available and ready to give the exam.....");

				User user = userDao.getUserdetails(email);
				int userClass = user.getUser_class();
				int userId = user.getId();
				System.out.println("Enter test number: ");

				int test_no = Integer.parseInt(br.readLine());

				List<Question> questionList = questionDao.showQuestion(userClass, test_no);

				List<Question> skippedQuestions = new ArrayList<>();
				Iterator<Question> question2 = questionList.iterator();

//				int qNo = 1;
				boolean checker = true;
				while (checker) {

					Question question = question2.next();
					System.out.println(question.getQuestion());

					int opNo = 1;
					List<Option> options = optionDao.showOptions(question.getQuestion_id());

					for (Option option : options) {
						System.out.println(opNo++ + ". " + option.getQ_option());
					}
					System.out.println(opNo + ". Skip");

					System.out.println("Enter Answer Sl Number: ");
					int optionEntered = Integer.parseInt(br.readLine());

					while (optionEntered < 1 || optionEntered > opNo) {
						System.out.println("Please enter the correct option no");
						optionEntered = Integer.parseInt(br.readLine());
					}
					int optionKey;
					if (optionEntered == opNo) {
						System.out.println("You skipped the question");
						skippedQuestions.add(question);
						optionKey = opNo;
					} else {
						optionKey = options.get(optionEntered - 1).getOption_id();

						userinputDao.saveAnswer(new UserInput(test_no, new User(userId), new Question(question.getQuestion_id()), new Option(optionKey)));
					}
					

					System.out.println("you entered option no " + optionEntered + " with option key " + optionKey);

					if (!question2.hasNext()) {

						questionList.clear();

						questionList.addAll(skippedQuestions);
						skippedQuestions.clear();

						question2 = questionList.iterator();

						if (questionList.size() == 0) {
							checker = false;
						}
					}
				}

				System.out.println("Type submit to submit the answer");
				String submit = br.readLine();

				if (submit.equalsIgnoreCase("submit")) {
					
					
					System.out.println("Question submitted successfully");
				} else {
					System.out.println("Question not submited");
				}

			} else {
				System.out.println("User is not available...");
				System.out.println("Please SignUp");

				System.out.println("Press y to signup or n to exit");
				String signup = br.readLine();

				if (signup.equalsIgnoreCase("y") || signup.equalsIgnoreCase("yes")) {
					AdminMenuService service = new AdminMenuService();

					service.addUser();
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}
	
	
	public void showResultByEmail() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Enter email id");
			String email = br.readLine();
			
			System.out.println("Enter test no:");
			int test_no = Integer.parseInt(br.readLine());
			
			ResultService resultService = new ResultService();
			
			resultService.showResultByEmail(email, test_no);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		
	}

}

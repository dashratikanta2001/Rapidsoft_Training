package com.quiz.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.quiz.App;
import com.quiz.dao.OptionDao;
import com.quiz.dao.QuestionDao;
import com.quiz.dao.TestNoDao;
import com.quiz.dao.UserDao;
import com.quiz.dao.UserInputDao;
import com.quiz.entity.Option;
import com.quiz.entity.Question;
import com.quiz.entity.TestNo;
import com.quiz.entity.User;
import com.quiz.entity.UserInput;

public class ExamService {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	UserDao userDao = App.context.getBean("userDao", UserDao.class);
	QuestionDao questionDao = App.context.getBean("questionDao", QuestionDao.class);
	OptionDao optionDao = App.context.getBean("optionDao", OptionDao.class);
	UserInputDao userinputDao = App.context.getBean("userInputDao", UserInputDao.class);
	TestNoDao testNoDao = App.context.getBean("testNoDao", TestNoDao.class);

	public void startExam() {
		// TODO Auto-generated method stub

		try {

			System.out.println("Enter email id:");
			String email = br.readLine();
			if (ControllerMenu.isValidEmail(email)) {

				User user = userDao.isUserAvailable(email);
				if (user != null) {
					System.out.println("User is available and ready to give the exam.....");

//				User user = userDao.getUserdetails(email);
					int userClass = user.getUser_class();
					int userId = user.getId();
					int test_no = 0;

					// get available test number for that user:

					List<Integer> givenTest = testNoDao.getAvailableTest(userId);

					List<Integer> testttt = new ArrayList<>();
					for (int i = 1; i <= 4; i++) {
						if (!givenTest.contains(i)) {
							testttt.add(i);
						}
					}
					while (test_no == 0) {
						test_no = selectTestNumber(testttt);
						if (test_no == Integer.MIN_VALUE) {
							break;
						} else if (test_no != 0 && test_no != Integer.MIN_VALUE) {

							List<Question> questionList = questionDao.showQuestion(userClass, test_no);

							if (!questionList.isEmpty()) {

								List<Question> skippedQuestions = new ArrayList<>();
								List<UserInput> userinputList = new ArrayList<>();
								Iterator<Question> question2 = questionList.iterator();

								while (question2.hasNext()) {
									Question question = question2.next();
									System.out.println(question.getQuestion());

									int opNo = 1;
									List<Option> options = optionDao.showOptions(question.getQuestion_id());

									for (Option option : options) {
										System.out.println(opNo++ + ". " + option.getQ_option());

									}
									System.out.println(opNo + ". Skip");
									System.out.println("Exit. To end the exam");

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

										userinputList.add(new UserInput(test_no, new User(userId),
												new Question(question.getQuestion_id()), new Option(optionKey)));

									}

//									System.out.println(
//											"you entered option no " + optionEntered + " with option key " + optionKey);

									if (!question2.hasNext()) {

										questionList.clear();

										questionList.addAll(skippedQuestions);
										skippedQuestions.clear();

										question2 = questionList.iterator();

										if (questionList.size() == 0) {
										}
									}

								}

								System.out.println("Type submit to submit the answer");
								String submit = br.readLine();

								if (submit.equalsIgnoreCase("submit")) {

									if (userinputDao.saveAnswers(userinputList)) {
										testNoDao.setTestDetails(test_no, user);
										System.out.println("Test submitted successfully");
									}

								} else {
									System.out.println("Test not submited");
								}
							} else {
								System.out.println("Question is not set yet");
							}
						}
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
			} else {
				System.out.println("Please enter valid Email id");
			}

		} catch (Exception e) {
			// TODO: handle exception

			if (e.getLocalizedMessage().toLowerCase().contains("exit")) {
				System.out.println("Exam has been ended and the answers are not been saved.");
			} else {
				System.out.println("Something went wrong Please Try again !!!!");

			}

		}
	}

	public void showResultByEmail() {
		// TODO Auto-generated method stub

		try {
			System.out.println("Enter email id");
			String email = br.readLine();
			if (ControllerMenu.isValidEmail(email)) {
				User user = userDao.isUserAvailable(email);

				if (user != null) {
					int test_no = 0;

//				User user = userDao.getUserdetails(email);
					int userId = userDao.getUserdetails(email).getId();

					List<Integer> availableTest = testNoDao.getAvailableTest(userId);

					if (!availableTest.isEmpty()) {

						while (test_no == 0) {
							test_no = selectTestNumber(availableTest);
							if (test_no == Integer.MIN_VALUE) {
								break;
							} else if (test_no != 0 && test_no != Integer.MIN_VALUE) {
								ResultService resultService = new ResultService();

								resultService.showResultByEmail(user, test_no);
							}

						}

					} else {
						System.out.println("You have not give the test.");
					}
				} else {
					System.out.println("User not available");
				}
			} else {
				System.out.println("Please enter valid Email id");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void showResultByClass() {
		// TODO Auto-generated method stub
		try {
			ResultService resultService = new ResultService();
			ControllerMenu cm = new ControllerMenu();

			boolean checker = true;
			int user_class = 0, testNo = 0;

			while (user_class == 0) {
				user_class = cm.setClassNo();
				if (user_class == Integer.MIN_VALUE) {
					break;
				} else if (user_class != Integer.MIN_VALUE && user_class != 0) {

					while (testNo == 0) {
						testNo = cm.setTestNo();
						if (testNo == Integer.MIN_VALUE) {
							break;
						} else if (testNo != Integer.MIN_VALUE && testNo != 0) {

							resultService.showMarkByClass(user_class, testNo);

						}
					}

				}
			}

		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void applyForRecheck() {
		// TODO Auto-generated method stub

		try {
			System.out.println("Enter email id:");
			String email = br.readLine();

			if (ControllerMenu.isValidEmail(email)) {

				User user = userDao.isUserAvailable(email);
				if (user != null) {
					System.out.println("User available");
					int test_no = 0;

					int user_class = user.getUser_class();

					int userId = userDao.getUserdetails(email).getId();

					List<Integer> availableTest = testNoDao.getAvailableTest(userId);

					if (!availableTest.isEmpty()) {

						while (test_no == 0) {
							test_no = selectTestNumber(availableTest);
							if (test_no == Integer.MIN_VALUE) {
								break;
							} else if (test_no != 0 && test_no != Integer.MIN_VALUE) {

								TestNo rechecked = testNoDao.isRechecked(userId, test_no);

								if (rechecked != null) {
									System.out.println("Are you sure to want to Apply for recheck (Y/N)");
									String conformation = br.readLine();
									if (conformation.equalsIgnoreCase("y") || conformation.equalsIgnoreCase("yes")) {
										testNoDao.setRechecked(rechecked);
										System.out.println("Thank you for apply");
									}

								} else {
									System.out.println("You have already applied for recheck");
								}

							}

						}
					} else {
						System.out.println("User does not attend Quiz");
					}

				} else {
					System.out.println("User not available");
				}
			} else {
				System.out.println("Please Enter valid Email id");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private int selectTestNumber(List<Integer> availableTest) {
		// TODO Auto-generated method stub

		int test_no = 0;
		try {
			boolean checker = true;
			while (checker) {
				System.out.println("Please select the Test number:");
				int i = 1;

				for (Integer test : availableTest) {
					System.out.println(i++ + ". Test No: " + test);
				}
				System.out.println("Exit. To Exit");

				String inputTestNo = br.readLine();

				inputTestNo = inputTestNo.toLowerCase();

				switch (inputTestNo) {

				case "1":
					test_no = availableTest.get(0);
					checker = false;
					break;
				case "2":
					test_no = availableTest.get(1);
					checker = false;
					break;
				case "3":
					test_no = availableTest.get(2);
					checker = false;
					break;
				case "4":
					test_no = availableTest.get(3);
					checker = false;
					break;
				case "exit":
					test_no = Integer.MIN_VALUE;
					checker = false;
					break;
				default:
					System.out.println("Please Select valid Test no..");
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Please Select valid Test no..");
//			e.printStackTrace();
		}

		return test_no;

	}

}

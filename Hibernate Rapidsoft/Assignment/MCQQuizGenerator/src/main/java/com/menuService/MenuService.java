package com.menuService;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.List;

import com.dao.optionsDAO.OptionsDAO;
import com.dao.questionAnswerDAO.QuestionAnswerDAO;
import com.dao.questionDAO.QuestionDAO;
import com.dao.userDAO.UserDAO;
import com.dao.userInputDAO.UserInputDAO;
import com.entity.optionEntity.Option;
import com.entity.questionEntity.Question;
import com.entity.userEntity.User;
import com.entity.userInputEntity.UserInput;
import com.userMarks.UserMark;

public class MenuService {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void addUser() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Name:");
			String name = br.readLine();
			System.out.println("Enter Phone No:");
			String phoneNo = br.readLine();
			System.out.println("Enter Email id:");
			String email = br.readLine();
			System.out.println("Enter Password: ");
			String psw = br.readLine();
			UserDAO ud = new UserDAO();
			System.out.println("Hey "+name+" User Id is :" + ud.addUserDAO(name, phoneNo, email, psw));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void startQuiz() {
		// TODO Auto-generated method stub
		System.out.println("Enter User Id:");
		try {
			int userId = Integer.parseInt(br.readLine());
			UserInputDAO user = new UserInputDAO();
			if (!user.ifUserAnswerExist(userId)) {

				QuestionAnswerDAO qa = new QuestionAnswerDAO();
				List<Question> questionList = qa.fetchQuestion();
				int qNo = 1;

				for (Question question : questionList) {
					System.out.println(qNo++ + ". " + question.getQuestion());

					List<Option> optionList = qa.fetchOptions(question.getId());
					int opNo = 1;

					for (Option option : optionList) {
						System.out.println(opNo++ + ") " + option.getOption());
					}

					System.out.println("Enter Answer Sl Number: ");
					int optionEntered = Integer.parseInt(br.readLine());

					while (optionEntered < 1 || optionEntered >= opNo) {
						System.out.println("Please enter the correct option no");
						optionEntered = Integer.parseInt(br.readLine());
					}

					int optionKey = optionList.get(optionEntered - 1).getId();

					System.out.println("You entered option no " + optionEntered + " with optionKey = " + optionKey);


					user.saveAnswer(
							new UserInput(new User(userId), new Question(question.getId()), new Option(optionKey)));

				}

			} else {
				System.out.println("You have already given the Quiz");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

	}

	public void showMarkById() {
		// TODO Auto-generated method stub
		System.out.println("Mark by id");

		UserMark um = new UserMark();

		System.out.println("Enter User Id:");
		int id;
		try {
			id = Integer.parseInt(br.readLine());
			um.getMarkById(id);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("User Id does not exist");
		}

	}

	public void showAllMarks() {
		// TODO Auto-generated method stub

		UserMark um = new UserMark();
		um.getAllMarks();

	}

	public void addQuestionOption() {
		// TODO Auto-generated method stub

		UserDAO u = new UserDAO();
		System.out.println("Enter user Id:");
		int uId;
		try {
			uId = Integer.parseInt(br.readLine());

			System.out.println("Enter Password:");
			String psw = br.readLine();
			if (u.loginUser(uId, psw)) {
				String input = "";
				do {
					System.out.println("Enter the Number to perform action:");
					System.out.println("1. Set Question");
					System.out.println("2. set Option");
					System.out.println("3. set Answer");
					System.out.println("Press 0 to exit");

					input = br.readLine();
					switch (input) {
					case "1":
						System.out.println("case 1");
						setQuestion();
						break;
					case "2":
						System.out.println("case 2");
						setOption();
						break;
					case "3":
						System.out.println("case 3");
						setAnswer();
						break;
					default:
						System.out.println("Exited");
						break;
					}

				} while (input.equals("1") || input.equals("2") || input.equals("3"));
			} else {
				System.out.println("Invalid crodential");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Invalid User");
		}

	}

	private void setQuestion() {
		// TODO Auto-generated method stub

		System.out.println("Enter Question :");
		try {
			String question = br.readLine();

			QuestionDAO qdao = new QuestionDAO();

			qdao.addQuestion(question);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Some Error occurs. please try again.");
		}

	}

	private void setOption() {
		// TODO Auto-generated method stub
		try {
			OptionsDAO opdao = new OptionsDAO();
			String input = "";
			int qId = -1;
			do {
				if (qId == -1) {
					System.out.println("Enter Question ID");
					qId = Integer.parseInt(br.readLine());
				}

				System.out.println("Enter Option");
				String option = br.readLine();
				opdao.addOption(qId, option);
				System.out.println("Add another option Y/N");
				input = br.readLine();

			} while (input.equalsIgnoreCase("y"));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Question Id does not exist.");
		}

	}

	private void setAnswer() {
		// TODO Auto-generated method stub
		QuestionAnswerDAO qadao = new QuestionAnswerDAO();
		try {

			System.out.println("Enter Question ID");
			int qId = Integer.parseInt(br.readLine());
			if (qadao.checkQASetOrNot(qId)) {
				System.out.println("Answer Already set");
			} else {
				qadao.setAnswer(qId);

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Question Id does not exist.");
		}

	}

}

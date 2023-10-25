package com.menuService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.dao.optionsDAO.OptionsDAO;
import com.dao.questionAnswerDAO.QuestionAnswerDAO;
import com.dao.questionDAO.QuestionDAO;
import com.dao.userDAO.UserDAO;

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
			System.out.println("Your User Id is :"+ud.addUserDAO(name, phoneNo, email, psw));
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void startQuiz() {
		// TODO Auto-generated method stub

	}

	public void showMarkById() {
		// TODO Auto-generated method stub
		System.out.println("Mark by id");

	}

	public void showAllMarks() {
		// TODO Auto-generated method stub
		System.out.println("All Mark");

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
		if(u.loginUser(uId, psw))
		{
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
		}
		else
		{
			System.out.println("Invalid crodential");
		}
		}catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void setQuestion() {
		// TODO Auto-generated method stub

		System.out.println("Enter Question :");
		try {
			String question = br.readLine();

			QuestionDAO qdao=new QuestionDAO();
			
			qdao.addQuestion(question);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setOption() {
		// TODO Auto-generated method stub
		try {
			OptionsDAO opdao = new OptionsDAO();
			String input = "";
			do {
				System.out.println("Enter Question ID");
				int qId = Integer.parseInt(br.readLine());
				System.out.println("Enter Option");
				String option = br.readLine();
				opdao.addOption(qId, option);
				System.out.println("Add another option Y/N");
				input = br.readLine();

			} while (input.equalsIgnoreCase("y"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	private void setAnswer() {
		// TODO Auto-generated method stub
		QuestionAnswerDAO qadao = new QuestionAnswerDAO();
		try {
			
			System.out.println("Enter Question ID");
			int qId = Integer.parseInt(br.readLine());
			qadao.setAnswer(qId);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

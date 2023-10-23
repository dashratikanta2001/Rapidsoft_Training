package com.menuService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.dao.userDAO.UserDAO;
import com.entity.optionEntity.Option;
import com.questionAnswerdao.QaDAO;

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
			ud.addUserDAO(name, phoneNo, email, psw);

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

	public void addQuestion() {
		// TODO Auto-generated method stub

		System.out.println("Enter Question :");
		try {
			String question = br.readLine();
			String input = "";
			QaDAO qadao = new QaDAO();
			do {
				System.out.println("Enter Answer");
				Option op = br.readLine();
				qadao.addQuestionAnswer(question, op);
				
				System.out.println("Add another option Y/N");
				input = br.readLine();

			} while (input.equalsIgnoreCase("y"));
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

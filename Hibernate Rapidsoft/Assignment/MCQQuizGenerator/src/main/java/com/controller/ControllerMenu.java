package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.menuService.MenuService;

public class ControllerMenu {

	public void menu() {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int menu = 0;
		do {

			displayMenu();
			try {
				menu = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switchCase(menu);
		} while (menu!=6);

	}

	private void displayMenu() {
		// TODO Auto-generated method stub

		System.out.println("___________________________________________");
		System.out.println("Enter the Menu Number to perform Operation:");
		System.out.println("1. Add User");
		System.out.println("2. Start Quiz");
		System.out.println("3. Show mark by ID");
		System.out.println("4. Show All marks");
		System.out.println("5. Add Question");
		System.out.println("6. Exit");
	}

	private void switchCase(int menu) {
		// TODO Auto-generated method stub
		MenuService ms = new MenuService();

		switch (menu) {
		case 1:
			System.out.println("Case 1 Entered");
			
			ms.addUser();
			
			break;
		case 2:
			System.out.println("Case 2 Entered");
			ms.startQuiz();
			break;
		case 3:
			System.out.println("Case 3 Entered");
			ms.showMarkById();
			break;
		case 4:
			System.out.println("Case 4 Entered");
			ms.showAllMarks();
			break;
		case 5:
			System.out.println("Case 5 Entered");
			ms.addQuestionOption();
			break;
		case 6:
			System.out.println("Case 6 Entered");
			System.out.println("Thank you");
			break;

		default:
			System.out.println("Invalid menu Entered");
			break;
		}

	}

}

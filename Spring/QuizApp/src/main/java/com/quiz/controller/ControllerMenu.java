package com.quiz.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ControllerMenu {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void menu() {
		// TODO Auto-generated method stub

		boolean checker = true;

		while (checker) {
			try {

				// Display the menu
				System.out.println("___________________________________________");
				System.out.println("Enter the Menu Number to perform Operation:");
				System.out.println("1. Admin");
				System.out.println("2. Exam");
				System.out.println("3. Result");
				System.out.println("4. Exit");
				System.out.println();

				// Enter menu value from user
				int menuNo = Integer.parseInt(br.readLine());
				ExamService examService = new ExamService();

				switch (menuNo) {
				case 1:
					System.out.println("No 1 selected");
					adminMenu();
					break;
				case 2:
					System.out.println("No 2 selected");
					
					examService.startExam();
					break;
				case 3:
					System.out.println("No 3 selected");
					examService.showResultByEmail();
					break;
				case 4:
					System.out.println("No 4 selected");
					checker = false;
					break;

				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please Enter valid menu number !!!");
			}
		}

	}
	
	private void adminMenu() {
		// TODO Auto-generated method stub

		boolean checker = true;

		while (checker) {
			try {
				AdminMenuService service = new AdminMenuService();
				// Display the menu
				System.out.println("___________________________________________");
				System.out.println("Enter the Menu Number to perform Operation:");
				System.out.println("1. Set Question");
				System.out.println("2. Set Option");
				System.out.println("3. Update Question");
				System.out.println("4. Update Option");
				System.out.println("5. Add user");
				System.out.println("6. Exit");
				System.out.println();
				
				// Enter menu value from user
				int menuNo = Integer.parseInt(br.readLine());

				switch (menuNo) {
				case 1:
//					System.out.println("No 1 selected");
					service.setQuestion();
					break;
				case 2:
//					System.out.println("No 2 selected");
					service.setOption();
					break;
				case 3:
					System.out.println("No 3 selected");
					break;
				case 4:
					System.out.println("No 4 selected");
					break;
				case 5:
//					System.out.println("No 5 selected");
					service.addUser();
					break;
				case 6:
//					System.out.println("No 5 selected");
					checker = false;
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please enter valid Menu number !!!");
				e.printStackTrace();
			}
		}
	}

}

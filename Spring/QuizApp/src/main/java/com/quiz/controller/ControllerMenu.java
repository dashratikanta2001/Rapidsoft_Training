package com.quiz.controller;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.regex.Pattern;

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
					resultMenu();
					break;
				case 4:
					System.out.println("No 4 selected");
					checker = false;
					break;
				default:
					System.out.println("Please enter valid Menu no");
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
				System.out.println("3. Add user");
				System.out.println("4. Exit");
				System.out.println();

				// Enter menu value from user
				int menuNo = Integer.parseInt(br.readLine());

				switch (menuNo) {
				case 1:
					service.setQuestion();
					break;
				case 2:
					service.setOption();
					break;
				case 3:
					service.addUser();
					break;
				case 4:
					checker = false;
					break;
				default:
					System.out.println("Please enter valid Menu no");
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please enter valid Menu number !!!");
				e.printStackTrace();
			}
		}
	}

	private void resultMenu() {
		// TODO Auto-generated method stub
		
		boolean checker = true;
		while (checker) {
			try {
				ExamService examService = new ExamService();
				System.out.println("___________________________________________");
				System.out.println("Enter the Menu Number to perform Operation:");
				System.out.println("1. Show result by email id");
				System.out.println("2. Show result by class");
				System.out.println("3. Apply for recheck");
				System.out.println("4. exit");

				int menuNo = Integer.parseInt(br.readLine());

				switch (menuNo) {
				case 1:
					examService.showResultByEmail();
					break;
				case 2:
					examService.showResultByClass();
					break;
				case 3:
					examService.applyForRecheck();
					break;
				case 4:
					checker=false;
					break;
				default:
					System.out.println("Please enter valid Menu no");

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}
	
	public int setClassNo() {
		// TODO Auto-generated method stub

		boolean classChecker = true;
		int classId = 0;
		try {

			while (classId == 0 && classChecker) {
				System.out.println("Select Class No.");
				System.out.println("1. Class 8");
				System.out.println("2. Class 9");
				System.out.println("3. Class 10");
				System.out.println("4. Exit");
				int classInput = Integer.parseInt(br.readLine());

				switch (classInput) {
				case 1:
					classId = 8;
					classChecker = false;
					break;
				case 2:
					classId = 9;
					classChecker = false;
					break;
				case 3:
					classId = 10;
					classChecker = false;
					break;
				case 4:
					classChecker = false;
					classId = Integer.MIN_VALUE;
					break;

				default:
					System.out.println("Please Enter valid number.");
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Please select Valid class no");
		}

		return classId;

	}

	public int setTestNo() {
		// TODO Auto-generated method stub
		int testNo = 0;
		boolean checker = true;
		try {
			while (checker) {
				System.out.println("Select Test No.");
				System.out.println("1. Test 1");
				System.out.println("2. Test 2");
				System.out.println("3. Test 3");
				System.out.println("4. Test 4");
				System.out.println("5. Exit");

				int inputtestNo = Integer.parseInt(br.readLine());

				switch (inputtestNo) {
				case 1:
					testNo = 1;
					checker = false;
					break;
				case 2:
					testNo = 2;
					checker = false;
					break;
				case 3:
					testNo = 3;
					checker = false;
					break;
				case 4:
					testNo = 4;
					checker = false;
					break;
				case 5:
					checker = false;
					testNo = Integer.MIN_VALUE;
					break;

				default:
					System.out.println("Please select valid number");
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Please select valid Test no");
		}

		return testNo;

	}
	
	
	public static boolean isValidEmail(String email) {
		// TODO Auto-generated method stub
		final String regx ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		
		return Pattern.matches(regx, email);
	}

}

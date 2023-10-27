package com.userMarks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.questionAnswerEntity.QuestionAnswer;
import com.entity.userEntity.User;
import com.entity.userInputEntity.UserInput;
import com.main.App;

public class UserMark {

	public void getMarkById(int userId) {
		// TODO Auto-generated method stub
		SessionFactory factory = App.factory;
		Session s = factory.openSession();
		int mark = 0;

		String ansQuery = "from QuestionAnswer";
		List<QuestionAnswer> ansList = s.createQuery(ansQuery, QuestionAnswer.class).getResultList();
		int totalMark = ansList.size();

		String userAnsQuery = "from UserInput";
		List<UserInput> userAnsList = s.createQuery(userAnsQuery, UserInput.class).getResultList();

		for (UserInput userInput : userAnsList) {

			for (QuestionAnswer questionAnswer : ansList) {

				if (userInput.getUser().getUser_id() == userId) {
					if (userInput.getQuestion().getId() == questionAnswer.getQuestion().getId()) {
						if (userInput.getOption().getId() == questionAnswer.getOption().getId()) {
							mark++;
						}
					}
				}
			}
		}

		System.out.println("Name : " + s.get(User.class, userId).getName());
		System.out.println("Mark Obtained : " + mark);
		System.out.println("Total Mark : " + totalMark);
		System.out.println("Grade: '" + gradeCalculator(mark, totalMark)+"'");
		
//		quizAttended();

	}

	public void getAllMarks() {
		// TODO Auto-generated method stub
		
		int studentPassed=0;
		int studentFailed=0;
		Map<Integer,Integer> attendedStudent = new HashMap<>();

		SessionFactory factory = App.factory;
		Session s = factory.openSession();

		String userQuery = "from User";
		List<User> userList = s.createQuery(userQuery, User.class).getResultList();

		String ansQuery = "from QuestionAnswer";
		List<QuestionAnswer> ansList = s.createQuery(ansQuery, QuestionAnswer.class).getResultList();

		int totalMark = ansList.size();
		String userAnsQuery = "from UserInput";
		List<UserInput> userAnsList = s.createQuery(userAnsQuery, UserInput.class).getResultList();

		for (User user : userList) {
			int mark = 0;

			for (UserInput userInput : userAnsList) {
				
				attendedStudent.put(userInput.getUser().getUser_id(), userInput.getUser().getUser_id());

				for (QuestionAnswer questionAnswer : ansList) {

					if (userInput.getUser().getUser_id() == user.getUser_id()) {
						if (userInput.getQuestion().getId() == questionAnswer.getQuestion().getId()) {
							if (userInput.getOption().getId() == questionAnswer.getOption().getId()) {
								mark++;
							}
						}
					}
				}
			}
			
			String grade=gradeCalculator(mark, totalMark);
			
			if(!grade.equals("D"))
			{
				studentPassed++;
			}
			else
			{
				studentFailed++;
			}
			
			System.out.println("Name : " + user.getName());
			System.out.println("Mark Obtained : " + mark);
			System.out.println("Total Mark : " + totalMark);
			System.out.println("Grade: '" + grade+"'");
			System.out.println("-------------------------------");

		}
		
		System.out.println("Total User available : "+userList.size());
		System.out.println("Total User Attended the Quiz : "+attendedStudent.size());
		System.out.println("Total User Passed: "+studentPassed);
		System.out.println("Total User Failed: "+studentFailed);

	}

	private String gradeCalculator(int obtained, int total) {
		// TODO Auto-generated method stub
		String grade = "";
		int mark = (obtained * 100) / total;

		switch (mark / 10) {
		case 10:
		case 9:
			return "O";
		case 8:
			return "A1";
		case 7:
			return "A2";
		case 6:
			return "B1";
		case 5:
			return "B2";
		case 4:
			return "C";
		default:
			return "D";
		}
	}
	
//	private int quizAttended() {
//		// TODO Auto-generated method stub
//		SessionFactory factory = App.factory;
//		Session s = factory.openSession();
//
//		String userQuery = "from UserInput";
//		List<UserInput> userList = s.createQuery(userQuery, UserInput.class).getResultList();
//		
//		Map<Integer,Integer> hs = new HashMap<>();
//		
//		
//		for (UserInput userInput : userList) {
//			hs.put(userInput.getUser().getUser_id(), userInput.getUser().getUser_id());
//		}
//		
//		return hs.size();
//	}

}

package com.userMarks;

import java.util.List;

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
		int totalMark=ansList.size();

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

		System.out.println("Name : " + s.get(User.class, userId).getName()) ;
		System.out.println("Mark Obtained : " + mark);
		System.out.println("Total Mark : "+totalMark);

	}

	public void getAllMarks() {
		// TODO Auto-generated method stub

		SessionFactory factory = App.factory;
		Session s = factory.openSession();

		String userQuery = "from User";
		List<User> userList = s.createQuery(userQuery, User.class).getResultList();

		String ansQuery = "from QuestionAnswer";
		List<QuestionAnswer> ansList = s.createQuery(ansQuery, QuestionAnswer.class).getResultList();

		int totalMark=ansList.size();
		String userAnsQuery = "from UserInput";
		List<UserInput> userAnsList = s.createQuery(userAnsQuery, UserInput.class).getResultList();

		for (User user : userList) {
			int mark = 0;

			for (UserInput userInput : userAnsList) {

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
//			System.out.println("Name : " + user.getName() + "\nMark Obtained: " + mark);
			
			System.out.println("Name : " +  user.getName());
			System.out.println("Mark Obtained : " + mark);
			System.out.println("Total Mark : "+totalMark);
			System.out.println("-------------------------------");

		}

	}
}

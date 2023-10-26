package com.dao.questionAnswerDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.dao.optionsDAO.OptionsDAO;
import com.entity.optionEntity.Option;
import com.entity.questionAnswerEntity.QuestionAnswer;
import com.entity.questionEntity.Question;
import com.main.App;

public class QuestionAnswerDAO {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private SessionFactory f = new Configuration().configure().buildSessionFactory();
	private Session session = f.openSession();
	private Map<Integer, String> optionMap = new HashMap<>();
	private ArrayList<Integer> optionIdArray = new ArrayList<>();

	public void setAnswer(int qId) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		try {
			int noOfOptions = 0;
			noOfOptions = showOptions(qId);
			if (noOfOptions == 0) {
				System.out.println("Invalid question id");
			} else {
				System.out.println("Enter Option Serial No to set as answer: ");
				int optionSLNo = Integer.parseInt(br.readLine());

				if (optionSLNo >= 1 && optionSLNo <= noOfOptions) {
					QuestionAnswer qa = new QuestionAnswer();
					Question q = session.get(Question.class, qId);
					Option op = session.get(Option.class, optionIdArray.get(optionSLNo - 1));

					qa.setOption(op);
					qa.setQuestion(q);

					session.save(qa);
					tx.commit();
					System.out.println("Option set successfully ............");
				} else {
					System.out.println("Invalid Option Id");
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Some error Occurs. Please try again");
		} finally {
			session.close();
			f.close();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean checkQASetOrNot(int qId) {
		// TODO Auto-generated method stub
		String query = "from QuestionAnswer";

		Query q = session.createQuery(query);

		List<QuestionAnswer> list = q.list();
		for (QuestionAnswer answer : list) {
			if (qId == answer.getQuestion().getId()) {
				return true;
			}
		}
		return false;
	}

	public int showOptions(int qId) {
		// TODO Auto-generated method stub

		OptionsDAO op = new OptionsDAO();
		optionMap.putAll(op.getOptions(qId));

		int i = 1;
		for (Map.Entry<Integer, String> option : optionMap.entrySet()) {
			System.out.println(i++ + ". " + option.getValue());
			optionIdArray.add(option.getKey());
		}

		return optionMap.size();

	}

	public List<Question> fetchQuestion() {
		SessionFactory f = App.factory;
		Session s = f.openSession();

		String query = "from Question";
		List<Question> questions = s.createQuery(query, Question.class).getResultList();
		
		s.close();
		return questions;
	}

	public List<Option> fetchOptions(int qId) {
		// TODO Auto-generated method stub

		SessionFactory f = App.factory;
		Session s = f.openSession();
		List<Option> options = new ArrayList<>();

		Question q = s.get(Question.class, qId);

		for (Option op : q.getOption()) {
			options.add(op);
		}

		s.close();
		return options;

	}

}

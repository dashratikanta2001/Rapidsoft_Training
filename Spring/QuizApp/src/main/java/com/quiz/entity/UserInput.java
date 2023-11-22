package com.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userInput")
public class UserInput {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userInput_id;

	@Column(columnDefinition = "int default 1",  name = "test_no")
	private int test_id;
	
//	@OneToOne
//	@JoinColumn(name = "test_id")
//	private TestNo test;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "question_id")
	private Question question;

	@OneToOne
	@JoinColumn(name = "option_id")
	private Option option;

	public UserInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInput(int test_id, User user, Question question, Option option) {
		super();
		this.test_id = test_id;
		this.user = user;
		this.question = question;
		this.option = option;
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public int getUserInput_id() {
		return userInput_id;
	}

}

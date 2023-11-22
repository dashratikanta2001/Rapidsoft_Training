package com.quiz.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class TestNo {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
//	private List<Question> question;
	
	@Column(name = "test_no")
	private int test_no;
	
	@Column(name = "isRechecked",columnDefinition = "boolean default false")
	private boolean isRechecked;
	
//	@OneToOne
//	private UserInput userInput;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public List<Question> getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(List<Question> question) {
//		this.question = question;
//	}

	public int getTest_no() {
		return test_no;
	}

	public void setTest_no(int test_no) {
		this.test_no = test_no;
	}

	public boolean isRechecked() {
		return isRechecked;
	}

	public void setRechecked(boolean isRechecked) {
		this.isRechecked = isRechecked;
	}

//	public UserInput getUserInput() {
//		return userInput;
//	}
//
//	public void setUserInput(UserInput userInput) {
//		this.userInput = userInput;
//	}

	public TestNo(int id, User user, int test_no, boolean isRechecked) {
		super();
		this.id = id;
		this.user = user;
//		this.question = question;
		this.test_no = test_no;
		this.isRechecked = isRechecked;
//		this.userInput = userInput;
	}

	public TestNo() {
		super();
		// TODO Auto-generated constructor stub
	}

}

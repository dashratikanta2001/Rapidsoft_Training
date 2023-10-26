package com.entity.userInputEntity;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.entity.optionEntity.Option;
import com.entity.questionEntity.Question;
import com.entity.userEntity.User;

@Entity
@Table(name = "user_input")
public class UserInput {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user ;
	
	@OneToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@OneToOne
	@JoinColumn(name = "option_id")
	private Option option ;

	public int getId() {
		return id;
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

	public UserInput(User user, Question question, Option option) {
		super();
		this.user = user;
		this.question = question;
		this.option = option;
	}

	public UserInput() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserInput(User user) {
		super();
		this.user = user;
	}
	
	
	
	
	

}

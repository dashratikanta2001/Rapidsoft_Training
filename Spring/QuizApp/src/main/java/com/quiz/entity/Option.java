package com.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "q_options")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int option_id;
	private String q_option;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	@Column(columnDefinition = "boolean default false")
	private boolean isAnswer;

	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Option(String q_option, Question question, boolean isAnswer) {
		super();
		this.q_option = q_option;
		this.question = question;
		this.isAnswer = isAnswer;
	}

	public String getQ_option() {
		return q_option;
	}

	public void setQ_option(String q_option) {
		this.q_option = q_option;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean isAnswer() {
		return isAnswer;
	}

	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}

	public int getOption_id() {
		return option_id;
	}

	public Option(int option_id) {
		super();
		this.option_id = option_id;
	}

}

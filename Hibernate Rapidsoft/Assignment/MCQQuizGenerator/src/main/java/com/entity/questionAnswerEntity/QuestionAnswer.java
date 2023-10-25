package com.entity.questionAnswerEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.entity.optionEntity.Option;
import com.entity.questionEntity.Question;

@Entity
@Table(name = "questionAnswer")
public class QuestionAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "q_id")
	private Question question;
	
	@OneToOne
	@JoinColumn(name = "op_id")
	private Option option;

	public int getId() {
		return id;
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


	public QuestionAnswer(Question question, Option option) {
		super();
		this.question = question;
		this.option = option;
	}


	public QuestionAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

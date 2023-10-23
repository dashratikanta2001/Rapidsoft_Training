package com.entity.optionEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.entity.questionEntity.Question;


@Entity
@Table(name = "option")
public class Option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String option;
	
	@ManyToOne
	@JoinColumn(name = "q_id")
	private Question question;

	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Option( String option, Question question) {
		super();
		this.option = option;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}

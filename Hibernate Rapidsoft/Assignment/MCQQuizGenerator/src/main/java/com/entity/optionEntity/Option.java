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
@Table(name = "q_options")	
public class Option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int o_id;
	private String q_option;
	
	@ManyToOne
	@JoinColumn(name = "q_id")
	private Question question;

	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Option( String option, Question question) {
		super();
		this.q_option = option;
		this.question = question;
	}

	public int getId() {
		return o_id;
	}

	public String getOption() {
		return q_option;
	}

	public void setOption(String option) {
		this.q_option = option;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Option(int o_id) {
		super();
		this.o_id = o_id;
	}

	
}

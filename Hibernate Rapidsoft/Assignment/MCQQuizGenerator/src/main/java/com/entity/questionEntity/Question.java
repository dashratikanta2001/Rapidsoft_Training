package com.entity.questionEntity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.entity.optionEntity.Option;


@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String question;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Option> option;

	

	public Question(String question, List<Option> option) {
		super();
		this.question = question;
		this.option = option;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}

	public int getId() {
		return id;
	}

	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
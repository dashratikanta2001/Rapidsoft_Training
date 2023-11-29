package com.assessment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_id;

	@Column(columnDefinition = "int default 1")
	private int test_no;
	
//	@ManyToOne
//	@JoinColumn(name = "test_id")
//	private TestNo test;
	
	private int class_id;
	private String question;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Option> option;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Question(int test_id, int class_id, String question, List<Option> option) {
		super();
		this.test_no = test_id;
		this.class_id = class_id;
		this.question = question;
		this.option = option;
	}

	public int getTest_id() {
		return test_no;
	}

	public void setTest_id(int test_id) {
		this.test_no = test_id;
	}



	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public Question(int question_id) {
		super();
		this.question_id = question_id;
	}
	

}

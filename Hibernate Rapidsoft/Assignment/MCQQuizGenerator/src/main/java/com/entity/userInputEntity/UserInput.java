package com.entity.userInputEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_input")
public class UserInput {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public UserInput(int id, int user_id, int question_id, int input_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.question_id = question_id;
		this.input_id = input_id;
	}
	public UserInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getInput_id() {
		return input_id;
	}
	public void setInput_id(int input_id) {
		this.input_id = input_id;
	}
	private int user_id;
	private int question_id;
	private int input_id;

}

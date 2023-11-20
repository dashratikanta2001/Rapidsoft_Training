package com.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "name")
	private String name;

	@Column(name = "rollNo")
	private String rollNo;
	
	@Column(name = "user_class")
	private int user_class;

	@Column(name = "isRechecked",columnDefinition = "boolean default false")
	private boolean isRechecked;

	public User() {
		super();
	}

	public User(String email, String name, String rollNo, int user_class, boolean isRechecked) {
		super();
		this.email = email;
		this.name = name;
		this.rollNo = rollNo;
		this.user_class = user_class;
		this.isRechecked = isRechecked;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public int getUser_class() {
		return user_class;
	}

	public void setUser_class(int user_class) {
		this.user_class = user_class;
	}

	public boolean isRechecked() {
		return isRechecked;
	}

	public void setRechecked(boolean isRechecked) {
		this.isRechecked = isRechecked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(int id) {
		super();
		this.id = id;
	}
	
	

}

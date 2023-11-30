package com.assessment.entity;

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
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rollno")
	private String rollno;
	
	@Column(name = "user_class")
	private int user_class;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public int getUser_class() {
		return user_class;
	}

	public void setUser_class(int user_class) {
		this.user_class = user_class;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", rollno=" + rollno + ", user_class="
				+ user_class + "]";
	}

	public User(int id) {
		super();
		this.id = id;
	}

	public User(int id, String email, String name, String rollno, int user_class) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.rollno = rollno;
		this.user_class = user_class;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

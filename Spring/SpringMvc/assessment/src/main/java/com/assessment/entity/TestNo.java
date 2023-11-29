package com.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "test")
public class TestNo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@Column(name = "test_no")
	private int test_no;
	
	@Column(name = "isRechecked",columnDefinition = "boolean default false")
	private boolean isRechecked;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public int getTest_no() {
		return test_no;
	}

	public void setTest_no(int test_no) {
		this.test_no = test_no;
	}

	public boolean isRechecked() {
		return isRechecked;
	}

	public void setRechecked(boolean isRechecked) {
		this.isRechecked = isRechecked;
	}


	public TestNo(int id, User user, int test_no, boolean isRechecked) {
		super();
		this.id = id;
		this.user = user;
		this.test_no = test_no;
		this.isRechecked = isRechecked;
	}

	public TestNo() {
		super();
		// TODO Auto-generated constructor stub
	}
}

package com.assignment.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Subject {
	
	@Id
	private int subId;
	private String subject;
	
	@OneToOne
	public Teacher t_id;

	public int getSubId() {
		return subId;
	}
	
	public Subject(int subId, String subject, Teacher t_id) {
		super();
		this.subId = subId;
		this.subject = subject;
		this.t_id = t_id;
	}

	public Teacher getT_id() {
		return t_id;
	}
	public void setT_id(Teacher t_id) {
		this.t_id = t_id;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Subject(int subId, String subject) {
		super();
		this.subId = subId;
		this.subject = subject;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

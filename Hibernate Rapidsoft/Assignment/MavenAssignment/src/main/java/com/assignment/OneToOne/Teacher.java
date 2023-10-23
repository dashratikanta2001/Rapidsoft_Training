package com.assignment.OneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Teacher {

	@Id
	private int TeacherId;
	private String TName;
	
	@OneToOne(mappedBy = "t_id", cascade = CascadeType.ALL)
	@JoinColumn(name = "subId")
	private Subject sub;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int teacherId, String tName, Subject sub) {
		super();
		TeacherId = teacherId;
		TName = tName;
		this.sub = sub;
	}

	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public String getTName() {
		return TName;
	}

	public void setTName(String tName) {
		TName = tName;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}
}

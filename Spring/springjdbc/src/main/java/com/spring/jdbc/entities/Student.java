package com.spring.jdbc.entities;

public class Student {

	private int id;
	private String name;
	private int physics;
	private int chemistry;
	private int math;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", physics=" + physics + ", chemistry=" + chemistry + ", math="
				+ math + "]";
	}

	public Student(int id, String name, int physics, int chemistry, int math) {
		super();
		this.id = id;
		this.name = name;
		this.physics = physics;
		this.chemistry = chemistry;
		this.math = math;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}

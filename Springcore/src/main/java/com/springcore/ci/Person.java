package com.springcore.ci;

public class Person {

	private String name;
	private int persionId;
	private Certi certi;
	public Person(String name, int persionId,Certi certi) {
		super();
		this.name = name;
		this.persionId = persionId;
		this.certi = certi;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return this.name+" : "+this.persionId+" {"+this.certi.name+"}";
	}
	
	
}

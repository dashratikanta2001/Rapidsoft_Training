// Write a program that creates an object of a Person class represents a person
// with a name and age. and overrides the toString() ,equals(),hashCode().
package com.assignment9.object;

class Person{
	String name = "Ratikanta";
	int age = 23;
	public String toString()
	{
		
		return "Hey "+name+" you are "+age+" year";
	}
	
	public int hashCode()
	{
		return 100;
	}
	
	public boolean equals(Object o)
	{
		
		System.out.println(this.hashCode()+" , "+ o.hashCode());
		return this.hashCode()==o.hashCode();
	}
	
}

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p = new Person();
		System.out.println(p);
		System.out.println(p.hashCode());
		System.out.println(p.equals(p));
	}

}

package com.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

class Person{
	String name;
	String rollno;
	
	public void getdetils()
	{
		System.out.println("Name: "+name);
		System.out.println("Roll no: "+rollno);
	}
}

class Student extends Person{
	String sclass;
	char section;
	public void getdetails() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Student Name:");
		name = reader.readLine();
		
		System.out.println("Enter Student Rollno:");
		rollno = reader.readLine();
		
		System.out.println("Enter Student Class:");
		sclass = reader.readLine();
		
		System.out.println("Enter Student Section:");
		section = reader.readLine().charAt(0);
		
		System.out.println("Name: "+name);
		System.out.println("Rollno: "+rollno);
		System.out.println("Class: "+sclass);
		System.out.println("Section: "+section);
		
	}
}

public class Question4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Student s = new Student();
		s.getdetails();
	}

}

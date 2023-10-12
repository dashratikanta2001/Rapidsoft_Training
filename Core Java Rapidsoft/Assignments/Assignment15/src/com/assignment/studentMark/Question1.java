//1. Write a Java method that takes a map of student names and their corresponding grades as
//parameters and returns the name of the student with the highest grade.

package com.assignment.studentMark;

import java.util.*;

public class Question1 {
	
	static String mapStudent(HashMap<String, Double> hs)
	{
		double grade = 0;
		String name="";
				
		for (Map.Entry<String, Double> entry : hs.entrySet()) {
			
			if(entry.getValue()>grade)
			{
				grade=entry.getValue();
				name=entry.getKey();
			}
		}
		
		return "Name of the Student: "+name+"\nGrade: "+grade;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Double> hs = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of student");
		int size = sc.nextInt();
		System.out.println("Enter student name and grade");
		for(int i=0;i<size;i++)
		{
			sc.nextLine();
			String name=sc.nextLine();
			double grade=sc.nextDouble();
			hs.put(name, grade);
			System.out.println("--------------------");
		}
		
		System.out.println(mapStudent(hs));
		sc.close();

	}

}

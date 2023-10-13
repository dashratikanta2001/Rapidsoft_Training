//5. Write a Java method that takes a map of student names and their corresponding marks in
//different subjects as parameters and returns the average marks for each student.

package com.assignment.averageMark;

import java.util.*;

public class Question5 {
	static void findAverage(HashMap<String, HashMap<String, Double>> std)
	{
		for (Map.Entry<String, HashMap<String, Double>> student : std.entrySet()) {
			double sum=0, avg=0;
			
			System.out.println("Name of Student: "+ student.getKey());
			
			HashMap<String, Double> stdetails = student.getValue();
			for (Map.Entry<String, Double> entry : stdetails.entrySet()) {
										
				sum+=entry.getValue();
				
				System.out.println(entry.getKey()+" : "+ entry.getValue());
			}
			avg=sum/3;
			System.out.println("Average mark: "+avg);
			System.out.println("____________________________");
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		HashMap<String, HashMap<String, Double>> student = new HashMap<>();
		HashMap<String, Double>stdetails = new HashMap<>();
		
		System.out.println("Enter number of Student:");
		int size = sc.nextInt();
		
		for(int i=0;i<size;i++)
		{
			System.out.println("Enter Name of student");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Enter marks for  Physics | Chemistry | Math");
			double p = sc.nextDouble();
			double c = sc.nextDouble();
			double m = sc.nextDouble();
			
			stdetails.put("Physics", p);
			stdetails.put("Chemistry", c);
			stdetails.put("Math", m);
			student.put(name, stdetails);
		}
		
		findAverage(student);
		sc.close();
	}

}

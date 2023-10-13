//4. Given a map of employee names and their corresponding salaries, write a Java method to
//find the employee with the highest salary.

package com.assignment.employee;

import java.util.*;

public class Question4 {
	
	static String mapStudent(HashMap<String, Double> hs)
	{
		double salary = 0;
		String empl="";
				
		for (Map.Entry<String, Double> entry : hs.entrySet()) {
			
			if(entry.getValue()>salary)
			{
				salary=entry.getValue();
				empl=entry.getKey();
			}
		}
		
		return "Employee: "+empl+"\n  Salary: "+salary;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Double> hs = new HashMap<>();

		hs.put("Ratikanta", 15000.00);
		hs.put("Sandeep", 16000.00);
		hs.put("Nikhil", 25000.00);
		hs.put("Manjit", 55000.00);
		hs.put("Soumya", 35000.00);

		System.out.println(mapStudent(hs));
	}

}

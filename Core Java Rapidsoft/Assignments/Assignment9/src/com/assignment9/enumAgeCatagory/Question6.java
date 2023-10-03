// .Write a program ,here we define an enum called AgeCategory which represents the 
//eligibility for voting. It has two enum values: ELIGIBLE and INELIGIBLE, each with 
//a corresponding message.The checkVotingEligibility() method takes an age as input
//and returns the appropriate AgeCategory based on the age.

package com.assignment9.enumAgeCatagory;

import java.util.Scanner;

enum AgeCategory{
	ELIGIBLE("Congrats, You are eligible"), INELIGIBLE("Sorry, You are not eligible");
	String message;
	private AgeCategory(String s) {
		// TODO Auto-generated constructor stub
		message = s;
		
	}
}

public class Question6 {
	static String checkVotingEligibility(int age)
	{
		AgeCategory a = AgeCategory.INELIGIBLE;
		if(age>18)
		{
			return a.ELIGIBLE.message;
		}
		return a.INELIGIBLE.message;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age");
		int age = sc.nextInt();
		System.out.println(checkVotingEligibility(age)+" to vote");
		
	}

}

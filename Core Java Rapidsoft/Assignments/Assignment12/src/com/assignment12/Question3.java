//3)Create a functional interface called Converter with a method convert(String str) that 
//returns an integer. Write a lambda expression that implements the Converter interface 
//to parse a string and return its length as an integer.

package com.assignment12;

import java.util.Scanner;

@FunctionalInterface
interface Converter
{
	int convert(String str);
}

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string: ");
		
		String str = sc.nextLine();
		
		Converter c =(st)->{
			return st.length();
		};
		
		System.out.println("Length of the string = "+ c.convert(str));
	}

}

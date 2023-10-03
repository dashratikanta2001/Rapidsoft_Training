// 2.Write a program that demonstrates the usage of wrapper classes by converting an 
// integer to a string and a string to an integer.

package com.assignment9.wrapperClass;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer a = Integer.valueOf("123");
		
		String s = String.valueOf(a);
		
		System.out.println("String to Integer converted value = "+ a+" and the sum with 5 is ="+ (a+5));
		System.out.println("Integer to String converted value = "+ s+" and the sum with 5 is ="+ (s+5));
		

	}

}

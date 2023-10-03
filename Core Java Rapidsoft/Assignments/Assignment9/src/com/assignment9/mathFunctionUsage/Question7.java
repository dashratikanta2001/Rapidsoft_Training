// Write a program to showcase the usage of functions such as Math.abs(), Math.sqrt(),
// Math.pow(), Math.max(), Math.min(), Math.random(), Math.floor(), Math.ceil(), and
// Math.round().  

package com.assignment9.mathFunctionUsage;

public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double num = -10.25;
		System.out.println("Absolute value = "+ Math.abs(num));
		
		int sqrt = 25;
		System.out.println("Square root is "+ Math.sqrt(sqrt));
		
		int pow = 4;
		System.out.println("Power is " + Math.pow(pow, 3));
		
		System.out.println("The max value is "+Math.max(sqrt, pow));
		
		System.out.println("The random number is "+ (int)(Math.random()*100));
		
		System.out.println("The floor number is "+ Math.floor(50/9));
		
		System.out.println("The ceil number is "+ Math.ceil(50/7));
		
		System.out.println("The round number is "+ Math.round(54.88));

	}

}

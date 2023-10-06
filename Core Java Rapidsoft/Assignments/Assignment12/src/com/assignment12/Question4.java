//4)  Write a program that uses lambda expressions to calculate the square root of each number 
//in a list of doubles. The program should take a list of doubles as input, use a lambda expression
//to calculate the square root of each number, and display the results as the output.

package com.assignment12;

import java.util.ArrayList;
import java.util.Scanner;

@FunctionalInterface
interface CalculateRoot
{
	void squareRoot(ArrayList<Double> n);
}

class SquareRootCalculate{
	
	public static void root(ArrayList<Double> num)
	{
		for(double d:num)
		{
			System.out.println("Square Root of "+d+" = "+ Math.sqrt(d));
		}
	}
}

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
				
		ArrayList<Double> arr = new ArrayList<Double>();
		
		System.out.println("Enter the double numbers: ");
		while(sc.hasNextDouble())
		{
			arr.add(sc.nextDouble());
		}
		
		CalculateRoot c = SquareRootCalculate::root;
		
		c.squareRoot(arr);
//		
//		for(double x:arr)
//		{
//			System.out.println("Square root of "+x+" = "+ c.squareRoot(x));
//		}
	}

}

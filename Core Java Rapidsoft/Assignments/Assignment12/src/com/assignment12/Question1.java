//1) Create a functional interface called MathOperation with a method calculate(int a, int b) 
//that returns an integer. Write a lambda expression that implements the MathOperation interface 
//to calculate the product of two numbers.

package com.assignment12;

import java.util.Scanner;

@FunctionalInterface
interface MathOperation
{
	public int calculate(int a, int b);
}

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of a");
		int a =sc.nextInt();
		System.out.println("Enter value of b");
		int b = sc.nextInt();
		
		MathOperation m = (x,y)->{
			return x*y;
		};
		
		System.out.println("Ans: "+m.calculate(a, b));

	}

}

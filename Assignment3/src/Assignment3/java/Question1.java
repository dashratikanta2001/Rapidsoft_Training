package Assignment3.java;

import java.util.Scanner;

class Calculator{
	int addition(int m,int n)
	{
		return m+n;
	}
	
	int addition(int m,int n, int p)
	{
		return m+n+p;
	}
	double addition(double m, double n)
	{
		return m+n;
	}
}

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Calculator c = new Calculator();
		
		System.out.println("Enter 2 Integer number");
		System.out.println("The sum of 2 Integer is "+c.addition(sc.nextInt(), sc.nextInt())); 
		
		System.out.println("Enter 3 Integer number");
		System.out.println("The sum of 3 Integer is "+c.addition(sc.nextInt(), sc.nextInt(),sc.nextInt())); 
		
		System.out.println("Enter 2 double number");
		System.out.println("The sum of 2 double is "+c.addition(sc.nextDouble(), sc.nextDouble())); 
		
	}

}

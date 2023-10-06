//2) handle all the exception using try catch and throws.

package com.assignment10;

public class Question2 {
	
	static void checkAge(int year1, int year2) throws ArithmeticException
	{
		int age = year2-year1;
		if(age<0)
		{
			throw new ArithmeticException("checkAge() -> throws || main() -> catch");
		}
		
		System.out.println(age);
	}
	
	static void checkHour(int hour1, int hour2) throws ArithmeticException
	{
		int hour = hour2-hour1;
		if(hour<0)
		{
			throw new ArithmeticException("checkHour() -> throws || main() -> throws");
		}
		
		System.out.println(hour);
	}

	public static void main(String[] args) throws ArithmeticException{
		// TODO Auto-generated method stub

		try {
			int A[] = {10,0,3};
			int r;
			
			r = A[0]/A[1];
			System.out.println(r);
			System.out.println(A[10]);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Divided by 0 is not possible");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array out of index");
		}
		
		//Throw and Throws
		try {
		checkAge(2000, 1980);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception catched \n" + e);
		}
		
		checkHour(9, 6);
	}

}

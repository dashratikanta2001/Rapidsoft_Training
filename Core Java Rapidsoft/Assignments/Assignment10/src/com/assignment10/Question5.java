//5) use final block

package com.assignment10;

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {10,0,3};
		try {
			int r;
			
			r = A[0]/A[1];
			System.out.println(r);
			
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("This is inside finally block");
			System.out.println("Value of A[2] = "+A[2]);			
		}
	}

}

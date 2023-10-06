//3) create  nested try and catch block.
	
package com.assignment10;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int A[] = {10,0,3};
			int r;
			try {
				r = A[0]/A[1];
				System.out.println(r);
			}
			catch(ArithmeticException e)
			{
				System.out.println("Divided by 0 is not possible");
			}
			System.out.println(A[10]);				
			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}

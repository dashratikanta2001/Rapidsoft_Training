//4) in a try block declare two catch block and show the use case for parent and child 
//class exception.

package com.assignment10;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int A[] = {10,5,3};
			int r;

			r = A[0]/A[1];
			System.out.println(r);
			System.out.println(A[5]);
			
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

package practice;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a,b,c;
		
//		try {
//			a=5;
//			b=2;
//			c=a/b;
//			
//			System.out.println(c);
//			System.out.println("End of program");
//		}
//		catch(ArithmeticException e)
//		{
//			System.out.println("division by zero "+e);
//		}
		
		//Try, Multiple Catch
		
		try {
			int A[] = {10,10,3};
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
		
		// Nested Try Catch
		
//		try {
//			int A[] = {10,0,3};
//			int r;
//			try {
//				r = A[0]/A[1];
//				System.out.println(r);
//			}
//			catch(ArithmeticException e)
//			{
//				System.out.println("Divided by 0 is not possible");
//			}
//			System.out.println(A[10]);				
//			
//		}
//		catch(ArrayIndexOutOfBoundsException e)
//		{
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		
		d2();
		System.out.println("Hello");
	}
	
	static void d1()
	{
		int a,b,c;
		try {
			a=5;
			b=0;
			c=a/b;
			
			System.out.println(c);
			System.out.println("End of program");
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	static void d2()
	{
		try {
			d1();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

package practice.oct3;

class NegetiveDimensionException extends Exception
{
	public String toString()
	{
		return "Dimension cant be Negetive";
	}
}

public class UserDefinedException {
	
	static int area(int l, int b) throws NegetiveDimensionException
	{
//		if(l<0 || b<0)
		try {
			throw new NegetiveDimensionException();			
		}
		finally {
			System.out.println("Final Message");
		}
//		return l*b;
	}

	public static void main(String[] args) throws NegetiveDimensionException{
		// TODO Auto-generated method stub

		try {
			System.out.println(area(-10,8));
			
		} catch (NegetiveDimensionException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		finally {
			System.out.println("This is in finally block");
		}
	}

}

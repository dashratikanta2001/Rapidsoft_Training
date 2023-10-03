package practice.oct3;

public class ThrowVsThrows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		meth1();

	}
	
	static void meth1()
	{
		try {
			int a = area(-10,5);
			System.out.println("Area = "+ a);			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("This should in meth1 method");
		}
	}
	
	static int area(int l, int b) throws Exception
	{
		if(l<0 || b<0)
			throw new Exception("L and B are can't be less than 0");
		return l*b;
	}

}

package Practice.Sept25;

public class MethodCalling {
	
	static int max(int x,int y)
	{
		if(x>y)
			return x;
		else 
			return y;
	}
	int max2(int x,int y)
	{
		if(x>y)
			return x;
		else 
			return y;
	}
	static void update(int A[])
	{
		A[0]=25;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10,b=20,c;
		c= max(a,b);
		System.out.println(c);
		
		MethodCalling mc = new MethodCalling();
		System.out.println(mc.max2(a, b));
		
		int A[] = {2,3,4,5,6};
		update(A);
		System.out.println(A[0]);
	}

}

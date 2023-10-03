package Practice.Sept25;

public class OverloadMethodToReverse {
	
	static int reverse(int n)
	{
		int rev = 0;
		while(n!=0)
		{
			rev = rev*10+n%10;
			n = n/10;
		}
		return rev;
	}
	
	static int [] reverse(int A[])
	{
		int B[] = new int [A.length];
		for(int i=A.length-1,j=0;i>=0;i--,j++)
		{
			B[j]=A[i];
		}
		return B;
		
	}
	static void show(int ...x)
	{
		for(int a:x)
		{
			System.out.print(a +" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {9,8,7};
		System.out.println(reverse(123));
		A=reverse(A);
		for(int x:A)
		{
			System.out.print(x + " ");
		}
		System.out.println();
		show(1,2,3);
		System.out.println();
		show(0,9,8,7,6,5,4,3,2,1);
	}

}

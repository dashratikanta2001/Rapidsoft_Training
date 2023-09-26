package Practice.Sept25;

public class FindGCD {
	static int Gcd(int n1,int n2)
	{
		while(n1!=n2)
		{
			if(n1>n2) n1 = n1-n2;
			else n2 = n2-n1;
		}
		return n1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=35,n=15;
		System.out.println(Gcd(m,n));
	}

}

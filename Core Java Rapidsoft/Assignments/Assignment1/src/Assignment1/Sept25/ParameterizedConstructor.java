package Assignment1.Sept25;

public class ParameterizedConstructor {
	public ParameterizedConstructor()
	{
		System.out.println("This is in without parameter constructor");
	}
	public ParameterizedConstructor(int x)
	{
		System.out.println("The value of integer x = "+x);
	}
	public ParameterizedConstructor(String x)
	{
		System.out.println("The value of String x = "+x);
	}
	public ParameterizedConstructor(int n, String x)
	{
		System.out.println("The value of integer n = "+n);
		System.out.println("The value of String  = "+x);
	}
	public ParameterizedConstructor(int m, int n, int p)
	{
		System.out.println("The value of m = "+m);
		System.out.println("The value of n = "+n);
		System.out.println("The value of p = "+p);
		System.out.println("The sum of m + n +p is = "+(m+n+p));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ParameterizedConstructor p1 = new ParameterizedConstructor();
		System.out.println();
		ParameterizedConstructor p2 = new ParameterizedConstructor(5);
		System.out.println();
		ParameterizedConstructor p3 = new ParameterizedConstructor("Hello");
		System.out.println();
		ParameterizedConstructor p4 = new ParameterizedConstructor(10,"Ratikanta");
		System.out.println();
		ParameterizedConstructor p = new ParameterizedConstructor(10,20,30);
	}

}

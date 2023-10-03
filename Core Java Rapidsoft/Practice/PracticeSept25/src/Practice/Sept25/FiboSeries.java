package Practice.Sept25;

import java.util.Scanner;

public class FiboSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the term");
		int n = sc.nextInt();
		
		int a=0,b=1,c;
		System.out.print(a+ ", " + b +", ");
		for(int i=2;i<n;i++)
		{
			c = a+b;
			System.out.print(c+", ");
			a=b;
			b=c;
		}
	}

}

package Practice.Sept25;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		if(n%2==0)
		{
			System.out.println("The number " + n + " is even");
		}
		else
		{
			System.out.println("The number " + n + " is odd");
		}

	}

}

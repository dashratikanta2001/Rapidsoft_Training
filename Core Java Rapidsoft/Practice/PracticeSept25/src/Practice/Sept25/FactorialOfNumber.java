package Practice.Sept25;

import java.util.Scanner;

public class FactorialOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i=0;i<=n;i++)
		{
			sum = sum+i;
		}
		System.out.println("Sum of "+n+" number is " +sum);

	}

}

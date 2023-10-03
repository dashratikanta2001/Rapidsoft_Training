package Practice.Sept25;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int num =n;
		int r,sum=0;
		while(n>0)
		{
			r = n%10;
			sum = sum+r*r*r;
			n = n/10;
		}
		if(num==sum)
		System.out.println("The number is Armstrong Number");
		else
			System.out.println("The number is not an Armstrong Number");

	}

}

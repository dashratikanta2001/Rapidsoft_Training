package Practice.Sept25;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = n;
		int r,rev=0;
		// reverse a number
		while(n>0)
		{
			r = n%10;
			rev = rev*10+r;
			n = n/10;
		}
		System.out.println("The reverse number is "+rev);
		
		// Palindrome number
		
		if(rev == m)
		{
			System.out.println("The number is pallindrome");
		}
		else {
			System.out.println("The number is not a pallindrome");
		}
	}

}

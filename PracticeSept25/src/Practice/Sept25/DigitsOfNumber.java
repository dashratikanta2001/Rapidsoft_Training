package Practice.Sept25;

import java.util.Scanner;

public class DigitsOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int r;
		
		// Display the digits
//		while(num>0)
//		{
//			r = num%10;
//			num = num/10;
//			System.out.println(r + " ");
//		}
		
		//Count the digits
		int count=0;
		while(num>0)
		{
			num = num/10;
			count++;
		}
		System.out.println("Number of digits = "+ count);
	}

}

package Practice.Sept25;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a year number");
		int year = sc.nextInt();
		if((year%4==0) && ((year%400==0) || (year%100!=0)))
		{
			System.out.println("The year "+year+" is leap year");
		}
		else
		{
			System.out.println("The year "+year+" is not a leap year");
		}

	}

}

package Practice.Sept25;

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m1,m2,m3;
		System.out.println("Enter marks of 3 Subjects");
		m1 = sc.nextInt();
		m2 = sc.nextInt();
		m3 = sc.nextInt();
		float avg = (float)(m1+m2+m3)/3;
		if(avg>=70)
		{
			System.out.println("Grade A");
		}
		else if (avg>=60)
		{
			System.out.println("Grade B");
		}
		else {
			System.out.println("Grade C");
		}
	}

}

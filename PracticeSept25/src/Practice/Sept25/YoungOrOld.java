package Practice.Sept25;

import java.util.Scanner;

public class YoungOrOld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int age;
		age = sc.nextInt();
		if(age >=14 && age<=60)
		{
			System.out.println("You are young");
		}
		else {
			System.out.println("You are not young");
		}

	}

}

package Practice.Sept25;

import java.util.Scanner;

public class ArithmaticOperationInSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n1,n2;
		System.out.println("Enter 2 number");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Menu in Words Like ADD/add/SUB/sub/MUL/mul/DIV/div");
		
		String menu = sc.nextLine();
		switch(menu)
		{
		case "add":
		case "ADD": System.out.println("The sum is " + (n1+n2));
					break;
		case "sub":
		case "SUB": System.out.println("The sub is " + (n1-n2));
					break;
		case "mul":
		case "MUL": System.out.println("The mul is " + (n1*n2));
					break;
		case "div":
		case "DIV": System.out.println("The div is " + (n1/n2));
					break;
		default:	System.out.println("Invalid Menu");
		
		}

	}

}

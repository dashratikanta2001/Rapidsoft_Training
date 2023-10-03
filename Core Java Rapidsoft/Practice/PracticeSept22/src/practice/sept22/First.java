package practice.sept22;

import java.util.Scanner;

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean a;
		int b, c;
//		Enter the integer value
		
//		System.out.println("Enter 2 number");
//		a = sc.nextInt();
//		b = sc.nextInt();
//		c = a+b;
//		System.out.println("The sum is "+ c);
		
//		Enter the String Value
		
//		String name;
//		System.out.println("Enter your Name");	
//		name = sc.next();
//		System.out.println("Hey "+name +"");
		
//		Chech for the Interger type or not at input time
		
//		System.out.println("Enter any integer number");
//		a = sc.hasNextInt();
//		System.out.println("The entered value is : "+ a);
		
//		useRadix() for receive the binary number
		
		System.out.println("Enter the number in binary format");
		sc.useRadix(2);
		b = sc.nextInt();
		System.out.println("The inputed number is "+b);

	}

}

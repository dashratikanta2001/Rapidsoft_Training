package Practice.Sept25;

import java.util.Scanner;

public class Radix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		String n = sc.nextLine();
		if(n.matches("[01]+"))
		{
			System.out.println("Binary Radix= 2");
		}
		else if(n.matches("[0-7]+"))
		{
			System.out.println("Octal Radix= 8");
		}
		else if(n.matches("[0-9]+"))
		{
			System.out.println("Decimal Radix= 10");
		}
		else if(n.matches("[0-9A-F]+"))
		{
			System.out.println("Hexa Radix= 16");
		}
		else {
			System.out.println("Not a number");
		}

	}

}

package Assignment3.java;

import java.util.Scanner;

class Rectangle{
	int area(int length, int width)
	{
		return length * width;
	}
	
	int area(int length)
	{
		return length*length;
	}
}

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Rectangle r = new Rectangle();
		
		System.out.println("Enter the length and breadth of rectangle");
		System.out.println("The area of rectangle is " + r.area(sc.nextInt(),sc.nextInt()));
		
		System.out.println("Enter the length  of rectangle");
		System.out.println("The area of rectangle is " + r.area(sc.nextInt()));

	}

}

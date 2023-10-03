package assignment.java;

import java.util.Scanner;

interface Area {
	public int calculateArea();
}

interface Perimeter {
	public int calculatePerimeter();
}

class Rectangle implements Area, Perimeter {
	int length;
	int breadth;
	
	Rectangle(int l,int b)
	{
		length = l;
		breadth = b;
	}
	
	@Override
	public int calculateArea() {
		return length * breadth;
	}
	
	@Override
	public int calculatePerimeter() {
		return 2 * (length + breadth);
		
	}
}


public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Length: ");
		int l = sc.nextInt();
		
		System.out.println("Enter Bredth: ");
		int b = sc.nextInt();
		
		Rectangle r = new Rectangle(l,b);
		System.out.println("Perimeter: " + r.calculatePerimeter());
		System.out.println("Area: " + r.calculateArea());

	}

}

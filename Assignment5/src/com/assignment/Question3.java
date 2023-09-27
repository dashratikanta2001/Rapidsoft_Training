package com.assignment;

class Shape{
	public double calculateArea()
	{
		return 0;
	}
}

class Rectangle extends Shape{
	double length=12.32;
	double bredth = 10.11;
	public double calculateArea()
	{
		return length*bredth;
	}
}

class Circle extends Shape{
	
	double radius = 5.6;
	
	public double calculateArea()
	{
		return Math.PI*radius*radius;
	}
}

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r = new Rectangle();
		System.out.println("Area of Rectangle = "+r.calculateArea());
		
		Circle c = new Circle();
		System.out.println("Area of Circle = "+c.calculateArea());
	}

}

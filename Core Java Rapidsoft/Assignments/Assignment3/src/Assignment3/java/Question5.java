package Assignment3.java;

class Shape{
	double calculateArea()
	{
		return 0;
	}
}

class Rectangle2 extends Shape{
	double calculateArea(double length, double width)
	{
		return length*width;
	}
}

class Circle extends Shape{
	double calculateArea(double radius)
	{
		return Math.PI*radius*radius;
	}
}

class Triangle extends Shape{
	double calculateArea(double b, double h)
	{
		return (0.5 * b*h);
	}
}

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle2 r = new Rectangle2();
		System.out.println("Area of Rectagle = "+r.calculateArea(6,7));
		
		Circle c = new Circle();
		System.out.println("Area of Circle = "+c.calculateArea(7));
		
		Triangle t = new Triangle();
		System.out.println("Area of Circle = "+t.calculateArea(6,5));
	}

}

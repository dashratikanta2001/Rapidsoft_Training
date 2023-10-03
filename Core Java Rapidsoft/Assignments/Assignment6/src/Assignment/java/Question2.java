package Assignment.java;

abstract class Shape{
	abstract public double perimeter();
	abstract public double area();
}

class Circle extends Shape{
	double radius;
	
	public double perimeter()
	{
		return 2*Math.PI*radius;
	}
	
	public double area()
	{
		return Math.PI*radius*radius;
	}
}

class Rectangle extends Shape{
	double length, bredth;
	
	public double perimeter()
	{
		return 2*(length+bredth);
	}
	
	public double area()
	{
		return length*bredth;
	}
}

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r = new Rectangle();
		r.bredth=5;
		r.length=10;
		Shape s = r;
		System.out.println("Area of Rectangle "+s.area());
		System.out.println("Perimeter of Rectangle "+s.perimeter());
		
		Circle c = new Circle();
		c.radius=6;
		s=c;
		System.out.println("Area of Rectangle "+c.area());
		System.out.println("Perimeter of Rectangle "+s.perimeter());
	}

}

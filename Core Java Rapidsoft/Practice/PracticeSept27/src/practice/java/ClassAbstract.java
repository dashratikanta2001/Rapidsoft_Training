package practice.java;

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
public class ClassAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r = new Rectangle();
		r.bredth=5;
		r.length=10;
		Shape s = r;
		System.out.println(s.area());
		
		Circle c = new Circle();
		c.radius=6;
		s=c;
		System.out.println(c.area());
		System.out.println(s.perimeter());
	}

}

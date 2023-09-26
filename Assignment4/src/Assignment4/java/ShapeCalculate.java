package Assignment4.java;

class Shape{
	
	public Shape()
	{
		System.out.println();
	}
			
}

class Rectangle extends Shape{
	public void perimeter(double length, double breadth)
	{
		System.out.println("Perimeter of rectangle is "+2*(length+breadth)); 
	}
	
	public void area(double length, double breadth)	
	{
		System.out.println("Area of rectangle is "+length*breadth); 
	}
}

class Triangle extends Shape{
	public void perimeter(double a, double b,double c)
	{
		System.out.println("Perimeter of triangle is "+(a+b+c)); 
	}
	
	public void area(double height, double base)
	{
		System.out.println("Area of triangle is "+(base*height)/2); 
	}
}

class Circle extends Shape{
	
	public void perimeter(double r)
	{
		System.out.println("Perimeter of circle is "+2*Math.PI*r); 
	}
	
	public void area(double r)
	{
		System.out.println("Area of circle is "+Math.PI*r*r); 
	}
}

public class ShapeCalculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle r = new Rectangle();
		r.perimeter(12, 5);
		r.area(12, 5);
		
		Triangle t = new Triangle();
		t.perimeter(5, 3, 7);
		t.area(10, 7);
		
		Circle c = new Circle();
		c.perimeter(14);
		c.area(14);
	}

}

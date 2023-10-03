package Practice.java;

class Circle{
	public double radius;
	public double area()
	{
		return Math.PI*radius*radius;
	}
	
	public double perimeter()
	{
		return 2*Math.PI*radius;
	}
	
	public double circumference()
	{
		return perimeter();
	}
}

class Cylinder2 extends Circle{
	public double height;
	public double volume()
	{
		return area()*height;
	}
}

public class PracticeInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cylinder2 c = new Cylinder2();
		c.radius=7;
		c.height=10;
		
		System.out.println("volume "+c.volume());
		System.out.println("Area "+c.area());
	}

}

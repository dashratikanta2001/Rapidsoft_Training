package Practice.java;

class Rectangle{
	private double length;
	private double breadth;
	
	public double getLength()
	{
		return length;
	}
	
	public double getBreadth()
	{
		return breadth;
	}
	
	public void setLength(double l)
	{
		if(l>=0)
			length=l;
		else
			length=0;
	}
	
	public void setBreadth(double b)
	{
		if(b>=0)
		breadth = b;
		else 
			breadth=0;
	}
	
	public double area()
	{
		return length*breadth;
	}
	
	public double perimeter()
	{
		return 2*(length+breadth);
	}
	
	public boolean isSquare()
	{
		if(length == breadth)
		{
			return true;
		}
		else
			return false;
	}
}

public class DataHiding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r = new Rectangle();
		r.setLength(-11.9);
		r.setBreadth(11.9);
		
		System.out.println("Area = "+r.area());
		System.out.println("Perimeter = "+r.perimeter());
		System.out.println("Is it a Square : "+r.isSquare());
		
		System.out.println("Length = "+r.getLength());
		System.out.println("Breadth = "+r.getBreadth());
	}

}

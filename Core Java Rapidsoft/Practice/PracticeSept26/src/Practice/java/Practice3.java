package Practice.java;

class Cylinder{
	private double radius;
	private double height;
	
	public Cylinder()
	{
		radius=height=1;
	}
	public Cylinder(double r)
	{
		radius=r;
		height=1;
	}
	
	public Cylinder(double r,double h)
	{
		radius=r;
		height=h;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setRadius(double r)
	{
		if(r>=0)
			radius = r;
		else
			radius=0;
	}
	
	public void setHeight(double h)
	{
		if(h>=0)
			height=h;
		else
			height=0;
	}
	
	public void setDimensions(double r, double h)
	{
		radius = r;
		height = h;
	}
	
	public double lidArea()
	{
		return Math.PI*radius*radius;
	}
	
	public double perimeter()
	{
		return 2*Math.PI*radius;
	}
	
	public double drumArea()
	{
		return 2*lidArea()+perimeter()*height;
	}
	
	public double volume()
	{
		return lidArea()*height;
	}
}

public class Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cylinder c = new Cylinder();
		c.setHeight(10);
		c.setRadius(7);
		c.setDimensions(10, 7);
		
		System.out.println("Lid Area = "+c.lidArea());
		System.out.println("Circumference = "+c.perimeter());
		System.out.println("Total Surface Area = "+c.drumArea());
		System.out.println("Volume = "+c.volume());
		System.out.println("Height = " +c.getHeight());
		System.out.println("Radius = "+c.getRadius());
	}

}

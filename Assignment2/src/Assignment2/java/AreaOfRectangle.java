package Assignment2.java;

class Rectangle{
	public int length;
	public int width;
	
	int areaOfRectangle()
	{
		return length*width;
	}
	int perimeterOfRectangle()
	{
		return 2*(length+width);
	}
}

public class AreaOfRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r1 = new Rectangle();
		r1.length=12;
		r1.width=5;
		System.out.println("Area of rectangle = "+ r1.areaOfRectangle());
		System.out.println("Perimeter of rectangle = "+ r1.perimeterOfRectangle());
	}

}

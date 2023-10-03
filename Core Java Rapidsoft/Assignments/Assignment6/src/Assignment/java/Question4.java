package Assignment.java;

interface Area{
	void area(int r);
}

interface Perimeter{
	void perimeter(int r);
}

class Circle1 implements Area,Perimeter{
	public void area(int r)
	{
		System.out.println("Area of Circle = "+ (2*Math.PI*r));
	}
	
	public void perimeter(int r)
	{
		System.out.println("Perimeter of Circle = "+ (Math.PI*r*r));
	}
}

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Circle1 c = new Circle1();
		c.area(5);
		c.perimeter(5);
	}

}

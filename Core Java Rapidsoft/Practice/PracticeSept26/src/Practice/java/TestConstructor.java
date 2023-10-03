package Practice.java;

class RectTest{
	private int length;
	private int breadth;
	
	public RectTest()
	{
		length=1;
		breadth=1;
		System.out.println("This is inside the without parameter constructor " + length +" " + breadth);
	}
	
	public RectTest(int l,int b)
	{
		length=l;
		breadth=b;
		System.out.println("This is inside the parameterised constructor " + length +" " + breadth);
	}
}

public class TestConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RectTest r = new RectTest();
		
		RectTest r1 = new RectTest(5,7);
	}

}

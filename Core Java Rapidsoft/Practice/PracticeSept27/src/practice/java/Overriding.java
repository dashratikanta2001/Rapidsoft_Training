package practice.java;

class Super{
	public void display()
	{
		System.out.println("Super class Display");
	}
}

class Sub extends Super{
	
	public void display()
	{
		System.out.println("Sub class Display");
	}
}

public class Overriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Super sup =new Super();
		sup.display();
		
		Sub s = new Sub();
		s.display();
	}

}

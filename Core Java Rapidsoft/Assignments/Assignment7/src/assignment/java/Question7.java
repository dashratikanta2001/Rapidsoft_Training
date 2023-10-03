package assignment.java;

class Outer4{
	int x = 99;
	static int y=10;
	static class Inner{
		
		public void innerDisplay()
		{
			System.out.println("This is in Local innerDisplay: y = "+y);
		}
	}
	
	public void outerDisplay()
	{
		new Inner().innerDisplay();
		System.out.println("This is in outerDisplay: x = "+x+", y = "+y);
	}
	
	
}

public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Outer4 o = new Outer4();
		o.outerDisplay();
		
		Outer4.Inner i = new Outer4.Inner();
		i.innerDisplay();
	}

}

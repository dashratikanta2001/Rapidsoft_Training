package assignment.java;

class Outer2{
	int x = 100;
	public void outerDisplay()
	{
		class Inner{
			int y = 13;
			
			public void innerDisplay()
			{
				System.out.println("This is in Local innerDisplay: x = "+x+", y = "+y);
			}
		}
		
		Inner i = new Inner();
		i.innerDisplay();
	}
	
	
}

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Outer2 o = new Outer2();
		o.outerDisplay();
	}

}

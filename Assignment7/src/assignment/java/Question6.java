package assignment.java;
class Outer3{
	int x = 99;
	public void outerDisplay()
	{
		class Inner{
			int y = 11;
			
			public void innerDisplay()
			{
				System.out.println("This is in Local innerDisplay: x = "+x+", y = "+y);
			}
		}
		
		new Inner().innerDisplay();
	}
	
	
}

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Outer3 o = new Outer3();
		o.outerDisplay();
	}

}

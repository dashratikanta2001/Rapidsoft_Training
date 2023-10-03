package assignment.java;

class Outer{
	int x=90;
	
	class Inner{
		int y = 12;
		
		public void innerDisplay()
		{
			System.out.println("This is in InnerDisplay: x="+x+", y= "+y);
		}
	}
	public void outerDisplay() {
		Inner i = new Inner();
		i.innerDisplay();
		System.out.println("This is in OuterDisplay: x = "+x);
	}
}


public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer o= new Outer();
		o.outerDisplay();

	}

}

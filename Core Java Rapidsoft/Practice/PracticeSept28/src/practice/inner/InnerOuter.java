package practice.inner;

class Outer{
	int x=90;
	Inner i = new Inner();
	
	class Inner{
		int y=78;
		public void innerDisplay()
		{
			System.out.println("x = "+x+", y = "+y);
			
			System.out.println("This is inner display object "+ i.y);
		}
	}
	
	public void outerDisplay()
	{
//		Inner i = new Inner();
		i.innerDisplay();
		System.out.println(i.y);
	}
}

class Outer2{
	int x=10;
	
	public void display()
	{
		class Inner{
			void show()
			{
				System.out.println("This is inside of Outer2 Inner class" + x);
			}
		}
		
		new Inner().show();
	}
}

public class InnerOuter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Outer o = new Outer();
		o.outerDisplay();
		
		Outer.Inner oi = new Outer().new Inner();
		System.out.println("Inner y = "+oi.y);
		
		System.out.println("-----------------------\n");
		Outer2 o2 = new Outer2();
		
		o2.display();
	}

}

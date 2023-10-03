package practice.java;

abstract class Super3{
	public Super3() {System.out.println("Super Constructor");}
	
	public void meth1()
	{
		System.out.println("Meth1 of Super");
	}
	abstract public void meth2();
}

class Sub3 extends Super3{
	@Override
	public void meth2()
	{
		System.out.println("Sub meth2");
	}
}

public class AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Super3 s = new Sub3();
		s.meth1();
		s.meth2();
	}

}

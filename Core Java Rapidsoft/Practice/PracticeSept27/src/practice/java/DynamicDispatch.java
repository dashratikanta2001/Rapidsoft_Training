package practice.java;

class Super2{
	public void meth1()
	{
		System.out.println("Super Meth1");
	}
	
	public void meth2()
	{
		System.out.println("Super Meth2");
	}
}

class Sub2 extends Super2{
	
	public void meth2()
	{
		System.out.println("Sub Meth2");
	}
	
	public void meth3()
	{
		System.out.println("Sub Meth3");
	}
}

public class DynamicDispatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Super2 sup = new Super2();
//		sup.meth1();
//		sup.meth2();
		
//		Sub2 s = new Sub2();
//		s.meth1();
//		s.meth2();
//		s.meth3();
		
		Super2 sup = new Sub2();
		sup.meth1();
		sup.meth2();
	}

}

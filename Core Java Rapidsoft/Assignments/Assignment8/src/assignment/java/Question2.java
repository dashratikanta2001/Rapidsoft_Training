package assignment.java;

interface Super{
//	final public void interfaceFinal();
	
	//We can't declare a method final in interface.
}

class Sub{
	final void classFinal()
	{
		System.out.println("This is a final method in Sub class");
	}
}

class Sub2 extends Sub{
//	final void classFinal()
//	{
//		System.out.println("We can't override a final method");
//	}
}

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sub2 s = new Sub2();
		
		s.classFinal();

	}

}

//Write a program to showcase overloading of method with the use of final variables .

package assignment.java;

class Super2{
	
}

class Sub3 extends Super2{
	
	
}

public class Question4 {

	final static int x=10;
	
	static void getx()
	{
		System.out.println("The value of x = "+x);
	}
	
	static void getx(int x)
	{
		int y=x;
		System.out.println("Overloaded method  x="+ x+" y = "+y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getx();
		getx(5);

	}

}

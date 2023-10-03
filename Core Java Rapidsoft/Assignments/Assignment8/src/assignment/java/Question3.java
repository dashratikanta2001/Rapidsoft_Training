//Write a program to restrict a class to create more than one object .
package assignment.java;

class  Restricted{
	private int num=0;
	
	static private Restricted rs = null;
	
	private Restricted()
	{
		num=num+1;
		System.out.println(num);
	}
	public void display()
	{
		System.out.println(num);
	}
	
	static Restricted getValue()
	{
		if(rs ==null)
		{
			rs = new Restricted();
		}
		return rs;
	}
	
}

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Restricted r1 = Restricted.getValue();
		Restricted r2 = Restricted.getValue();
		Restricted r3 = Restricted.getValue();
		
		System.out.println("r1 = "+r1+" r2 = "+r2+" r3 = "+r3);
		
		r1.display();
		r2.display();
		r3.display();

	}

}

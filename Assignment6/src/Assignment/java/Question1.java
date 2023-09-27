package Assignment.java;

abstract class Super{
	abstract public void start();
	abstract public void stop();
}

class Sub1 extends Super implements Main{
	public void start()
	{
		System.out.println("Sub1 class Started");
		callbackAbstract();
	}
	
	public void stop()
	{
		System.out.println("Sub1 class Stoped");
	}
	
	public void callbackAbstract()
	{
		System.out.println("This is in interface method in sub1");
	}
}

class Sub2 extends Super implements Main{
	public void start()
	{
		System.out.println("Sub2 class Started");
		callbackAbstract();
	}
	
	public void stop()
	{
		System.out.println("Sub2 class Stoped");
	}
	public void callbackAbstract()
	{
		System.out.println("This is in interface method in sub2");
	}
}

interface Main{
		void callbackAbstract();
}

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sub1 sub1 = new Sub1();
		
		sub1.start();
		sub1.stop();
		
		Sub2 sub2 = new Sub2();
		sub2.start();
		sub2.stop();
		

	}

}

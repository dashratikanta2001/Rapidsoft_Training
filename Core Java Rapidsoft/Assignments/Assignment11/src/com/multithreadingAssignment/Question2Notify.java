package com.multithreadingAssignment;

class NumberPatternThread2{
	
	static boolean isnum = false;
	
	synchronized boolean num1( int i)
	{
		while(isnum!=false)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.print(i +" ");
		notify();
		return true;
	}
	
}

class PrintPattern1  extends Thread
{
	NumberPatternThread2 n;
	public PrintPattern1(NumberPatternThread2 np) {
		// TODO Auto-generated constructor stub
		n = np;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//Pattern1
		System.out.print("a:- ");
		for(int i=1; i<=10 && n.num1(i);i++);
		for(int i=1; i<=10 && n.num1(i);i++);
		
		//Pattern2
		System.out.print("\nb:- ");
		for(int i=1; i<=10 && n.num1(i);i++)
		{
			n.num1(i);
		}
		
		
	}
}

public class Question2Notify {
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberPatternThread2 n = new NumberPatternThread2();
		PrintPattern1 p1 = new PrintPattern1(n);
		
		p1.start();
		
		
	}

}

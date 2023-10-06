//2) Write a Java program to create and start two threads. Each thread should print numbers 
//from 1 to 10. Ensure that the numbers are printed in sequence.
//For 2nd question, 
//write programs for these two 
//outputs :
//a :- 1 2 3 4 5 6 7 8 9 10 1 2 3 4 5 6 7 8 9 10
//b :- 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10 


package com.multithreadingAssignment;

class NumberPatternThread extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count =1;
		
		while(count<=10)
		{
			System.out.print(count++ +" ");
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				System.out.println(e);
			}
			
		}
	}

}

public class Question2 {
	static NumberPatternThread nm1; 
	static NumberPatternThread nm2; 
	
	static void printPatternA()
	{
		nm1 = new NumberPatternThread();
		nm2 = new NumberPatternThread();
		System.out.print("a:- ");
		nm1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		nm2.start();
		try {
			nm2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void printPatternB()
	{
		nm1 = new NumberPatternThread();
		nm2 = new NumberPatternThread();
		System.out.print("b:- ");
		nm1.start();
		nm2.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPatternA();
		System.out.println();
		printPatternB();
		
	}

}

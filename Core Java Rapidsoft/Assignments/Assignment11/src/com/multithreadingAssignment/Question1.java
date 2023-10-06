//1) Create program to use the mentioned methods using java  multi-threading- 
//start(),run(),sleep(),currentThread(),getPriority(),setPriority(),isAlive(),stop(), destroy(),
//add each screen shot of the output.

package com.multithreadingAssignment;

class MyThread extends Thread{
	public MyThread (String name)
	{
		super(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count =0;
		for(;count<20;count++)
		{
			System.out.print(count+" ,");
			if(count>8)
				break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
}

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread mt1 = new MyThread("Thread1");
		
		System.out.println("Thread State: "+mt1.getState());
		mt1.start();
		System.out.println("Thread State: "+mt1.getState());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("Thread State: "+mt1.getState());

		System.out.println("\nCurrent Thread = "+ Thread.currentThread());
		System.out.println("Thread Priority = "+ mt1.getPriority());
		System.out.println("Priority set to 8");
		mt1.setPriority(mt1.MAX_PRIORITY-2);
		System.out.println("Thread Priority = "+ mt1.getPriority());
		System.out.println("Thread is alive ?: "+mt1.isAlive());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nThread Stop: " ); 
//		mt1.stop();
//		mt1.interrupt();
		System.out.println("Thread is alive ?: "+mt1.isAlive());

	}

}

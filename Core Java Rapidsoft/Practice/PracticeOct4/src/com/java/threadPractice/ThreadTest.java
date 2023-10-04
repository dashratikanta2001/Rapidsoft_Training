package com.java.threadPractice;

//class MyRun implements Runnable
//{
//	public void run() {}
//}

class MyThread extends Thread{
	public MyThread(String name)
	{
		super(name);
//		setPriority(Thread.MAX_PRIORITY-1);
	}
	
	public void run()
	{
		int count=1;
		while(true)
		{
			System.out.println(count++);
			try {
				Thread.sleep(1000);				
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Thread t = new Thread(new MyRun(),"My name");
//		Thread t = new Thread(new MyRun());
//		Thread t = new Thread("My name");
		
		MyThread t = new MyThread("My Thread 1");
		t.start();
		t.interrupt();
//		t.setPriority(8);
		
		System.out.println("ID: "+t.getId());
		System.out.println("Name: "+t.getName());
		System.out.println("Priority: "+t.getPriority());
//		t.start();
		System.out.println("State: "+t.getState());
		System.out.println("Alive: "+ t.isAlive());
	}

}

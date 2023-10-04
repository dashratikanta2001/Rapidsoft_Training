package com.java.threadPractice;

class Mythread extends Thread
{
	public void run()
	{
		int count=1;
		while(true)
		{
			System.out.println(count++ +" My Thread");
		}
	}
}

public class DaemonThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mythread t = new Mythread();
//		t.setDaemon(true);
		t.start();
//		try {Thread.sleep(100);}catch(Exception e) {}
		
//		Thread mainThread = Thread.currentThread();
//		try {
//			mainThread.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			
//		}
		
		
		//Yield Thread
		
		int count=1;
		while(true)
		{
			System.out.println(count++ +" Main");
			Thread.yield();
		}
	}

}

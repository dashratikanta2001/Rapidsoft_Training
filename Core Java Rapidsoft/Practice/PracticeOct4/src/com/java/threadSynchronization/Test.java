package com.java.threadSynchronization;

class MyData{
	synchronized void display(String str)
	{
//		synchronized (this) {
		
		for(int i=0;i<str.length();i++)
		{
			System.out.print(str.charAt(i)+",");
			try {Thread.sleep(100);}catch(Exception e) {}
		}
		System.out.println();
		
//		}
	}
}

class MyThread1 extends Thread
{
	MyData d1;
	MyThread1(MyData dat){d1=dat;}
	
	public void run()
	{
		d1.display("Hello World");
	}
}

class MyThread2 extends Thread
{
	MyData d2;
	MyThread2(MyData dat){d2=dat;}
	
	public void run()
	{
		d2.display("Ratikanta");
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyData d = new MyData();
		MyThread1 t1 = new MyThread1(d);
		MyThread2 t2 = new MyThread2(d);
		t1.start();
		t2.start();
	}

}

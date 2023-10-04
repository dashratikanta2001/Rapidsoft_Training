package com.java.threadProducer;
class MyData{
	int value=0;
	boolean flag=true;
	synchronized void set(int v)
	{
		while(flag!=true)
			try {
				wait();
			} catch (InterruptedException e) {}
		
		value=v;
		flag=false;
		notify();
	}
	
	synchronized int get()
	{
		while(flag!=false)
			try {
				wait();
			} catch (InterruptedException e) {}
		
		int x=0;
		x = value;
		flag=true;
		notify();
		return x;
	}
}

class Producer extends Thread
{
	MyData d;
	Producer(MyData dat)
	{
		d=dat;
	}
	
	public void run()
	{
		int i=1;
		while(true)
		{
			d.set(i);
			System.out.println("Producer: "+i);
			i++;
		}
	}
}

class Consumer extends Thread{
	MyData d;
	Consumer(MyData dat)
	{
		d = dat;
	}
	
	public void run()
	{
		while(true)
		{
			System.out.println("Consumer: "+d.get());
		}
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyData d = new MyData();
		
		Producer p = new Producer(d);
		
		Consumer c1 = new Consumer(d);
		Consumer c2 = new Consumer(d);
		Consumer c3 = new Consumer(d);
		p.start();
		c1.start();
		c2.start();
		c3.start();
		
	}

}

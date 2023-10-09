package com.pipediostream;

import java.io.*;

class Producer extends Thread{
	OutputStream os;
	
	public Producer(OutputStream o) {
		// TODO Auto-generated constructor stub
		os=o;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count =1;
		while(true)
		{
			try {
				os.write(count);
				os.flush();
				System.out.println("Producer "+ count);
				System.out.flush();
				
				Thread.sleep(100);
				
				count++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class Consumer extends Thread{
	InputStream is;
	
	public Consumer(InputStream i) {
		// TODO Auto-generated constructor stub
		is=i;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int x;
		while(true)
		{
			try {
				x=is.read();
				System.out.println("Consumer "+ x);
				Thread.sleep(100);
				System.out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

public class PipedStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		
		pis.connect(pos);
		
		Producer p = new Producer(pos);
		Consumer c = new Consumer(pis);
		
		p.start();
		c.start();
		
	}

}

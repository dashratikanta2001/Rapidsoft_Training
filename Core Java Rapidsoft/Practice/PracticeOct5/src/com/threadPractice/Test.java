package com.threadPractice;
class Notifier {
	int i=1;
	private boolean isNotified = false;
	public synchronized void notifyAllThreads() {		
		isNotified = true;
		notifyAll();
	}

	public synchronized void waitForNotification() {

		while(!isNotified) {
			try {
				System.out.print(" Waited "+i+++"   \n");
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(" ........ "+i+++"   ");

		}
	}
}

public class Test {
	static int i=1;
	static int rt()
	{
		if(i==20)
			i=1;
		return i++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Notifier notifier = new Notifier();
//		int i=1;
		for(int j=1;j<20;j++)
		{
			Thread thread = new Thread(() -> {
				System.out.println("Thread "+rt()+" waiting for notification.");
				notifier.waitForNotification();

				System.out.println("Thread "+rt()+" received notification.");
			});
			
			thread.start();
		}

//		Thread thread1 = new Thread(() -> {
//			System.out.println("Thread waiting for notification.");
//			notifier.waitForNotification();
//			System.out.println("Thread 1 received notification.");
//		});
//
//		Thread thread2 = new Thread(() -> {
//			System.out.println("Thread 2 waiting for notification.");
//			notifier.waitForNotification();
//			System.out.println("Thread 2 received notification");
//
//		});
//		Thread thread3 = new Thread(() -> {
//			System.out.println("Thread 3 waiting for notification.");
//			notifier.waitForNotification();
//			System.out.println("Thread 3 received notification.");
//		});
//
//		Thread thread4 = new Thread(() -> {
//			System.out.println("Thread 4 waiting for notification.");
//			notifier.waitForNotification();
//			System.out.println("Thread 4 received notification");
//
//		});
//		Thread thread5 = new Thread(() -> {
//			System.out.println("Thread 5 waiting for notification.");
//			notifier.waitForNotification();
//			System.out.println("Thread 5 received notification.");
//		});
//
//		Thread thread6 = new Thread(() -> {
//			System.out.println("Thread 6 waiting for notification.");
//			notifier.waitForNotification();
//			System.out.println("Thread 6 received notification");
//
//		});

//		thread1.start();
//		thread2.start();
//		thread3.start();
//		thread4.start();
//		thread5.start();
//		thread6.start();

		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println();
		synchronized(notifier) {
			notifier.notifyAllThreads();
		}
	}

}

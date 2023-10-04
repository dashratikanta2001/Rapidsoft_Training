package com.java.threadStudent;

class WhiteBoard
{
	String text;
	int noOfStudent=0,studentRead=0;
	synchronized void write(String msg)
	{
		System.out.println("---------------------------------------------------------------Teacher is Writing : "+ msg);
		while(studentRead!=0 )
			try {
				System.out.println("-------------------------------------------------------Write try");
				wait();
			} catch (InterruptedException e) {
				System.out.println("Write Ex");
			}
		text=msg;
		studentRead=noOfStudent;
		notifyAll();
	}
	
	synchronized String read()
	{
		
		while(studentRead==0)
			try {
				System.out.println("-------------------------------------------------------Read try");
				wait();
			} catch (InterruptedException e) {
				System.out.println("Read Ex");
			}
		String val=text;
		studentRead--;
		if(studentRead==0)
		{			
			notify();
		}
		
		return val;
	}
	
	void attendance()
	{
		noOfStudent++;
		System.out.println("-------------------------------------------------------student "+ noOfStudent);
	}
	
	
}

class Teacher extends Thread
{
	WhiteBoard w;
	String notes[] = {"a. Java is a Language","b. It is OOPS","c. It supports Multithreading", "d. End"};
	
	public Teacher(WhiteBoard wh) {
		w = wh;
	}
	public void run()
	{
		for(String s:notes)
		{
			w.write(s);
		}
	}
}

class Student extends Thread
{
	String name;
	WhiteBoard w;
	
	public Student(WhiteBoard wh, String n) {
		name = n;
		w=wh;
	}
	
	public void run()
	{
		String text;
		w.attendance();
		do
		{
			text=w.read();
			System.out.println(name+ " Reading "+ text);
			System.out.flush();
			System.out.println();
		}while(!text.equals("d. End"));
	}
}

public class TSWThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WhiteBoard w = new WhiteBoard();
		
		Teacher t = new Teacher(w);
		
		Student s1 = new Student(w,"1. Ratikanta");
		Student s2 = new Student(w,"2. Muktikanta");
		Student s3 = new Student(w,"3. Ashish");
		
		t.start();
		s1.start();
		s2.start();
		s3.start();
	}

}

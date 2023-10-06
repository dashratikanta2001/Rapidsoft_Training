package com.threadPractice;

class WhiteBoard{
	
	String text;
	int noOfStudent=0, studentRead=0;
	synchronized void write(String msg)
	{
		while(studentRead!=0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		text= msg;
		System.out.println("Teacher is Writing : "+ text);
		studentRead=noOfStudent;
		notifyAll();
	}
	
	synchronized public String read()
	{
		while(studentRead==0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String val= text;
		studentRead--;
		if(studentRead==0)
			notify();
		return val;
	}
	
	void attendance()
	{
		noOfStudent++;
	}
	
}

class Teacher extends Thread
{
	WhiteBoard wh;
	String note[] = {"a. 11","b. 2222222222","c. 333333333333333", "d. 44444444444444444444"};
	
	Teacher(WhiteBoard w)
	{
		wh=w;
	}
	
	public void run()
	{
		for(String s:note)
			wh.write(s);
	}
}

class Student extends Thread
{
	String name;
	WhiteBoard wh;
	Student(WhiteBoard w, String name)
	{
		wh=w;
		this.name = name;
	}
	
	public void run()
	{
		wh.attendance();
		String text;
		
		do {
			text = wh.read();
			System.out.println(name+" is reading "+text);
		} while (!text.equals("d. 44444444444444444444"));
	}
}

public class PracticeThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WhiteBoard w = new WhiteBoard();
		
		Teacher t = new Teacher(w);
		
		Student s1 = new Student(w, "Student1");
		Student s2 = new Student(w, "Student2");
		Student s3 = new Student(w, "Student3");
		Student s4 = new Student(w, "Student4");
		Student s5 = new Student(w, "Student5");
		Student s6 = new Student(w, "Student6");
		
		t.start();
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s5.start();
		s6.start();

	}

}

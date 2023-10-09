package com.serialization.dummy;

import java.io.*;

class Student implements Serializable{
	private int rollno;
	private String name;
	private float avg;
	private String dept;
	public static int Data=10;
	public transient int t;

	
	public Student(int r,String n,float a, String d)
	{
		rollno=r;
		name=n;
		avg =a;
		dept=d;
		Data=500;
		t=500;
	}

	public String toString()
	{
		return "\nStudent Details"+
				"\nRoll: "+rollno+
				"\nName: "+name+
				"\nAverage: "+avg+
				"\nDept: "+dept+
				"\nData: "+Data+
				"\nTransient: "+t;
	}
}

public class ObjectDemo {

	//Object Write
		
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//
//		FileOutputStream fos = new FileOutputStream("Student.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//		Student s = new Student(10,"John",89.9f,"CSE");
//		oos.writeObject(s);
//
//		fos.close();
//		oos.close();
//	}
		 

	//Object Read
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
	
			FileInputStream fis = new FileInputStream("Student.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			Student s =(Student) ois.readObject();
	
			System.out.println(s);
			fis.close();
			ois.close();
		}

}

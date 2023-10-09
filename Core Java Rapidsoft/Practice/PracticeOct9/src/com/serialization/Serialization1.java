package com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


@SuppressWarnings("serial")
class Student implements Serializable
{
	int rollno;
	String name;
	String dept;
}

public class Serialization1 {
	
	private static void myWrite() throws IOException {
		// TODO Auto-generated method stub

		FileOutputStream fo = new FileOutputStream("testStudent3.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fo);
		
		Scanner sc = new Scanner(System.in);

//		int i=0;
		for(int i=0;i<4;i++)
		{
			Student s = new Student();
			System.out.println("Enter roll, name, dept and roll no of Student"+i);
			s.rollno=sc.nextInt();
			sc.nextLine();
			s.name=sc.nextLine();
			s.dept=sc.nextLine();
			
			oos.writeObject(s);
		}

		sc.close();
		oos.close();
		fo.close();
	}

	private static void myRead() throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fi = new FileInputStream("testStudent3.txt");
		ObjectInputStream ois = new ObjectInputStream(fi);
		Student s;

		for(int i=0;i<4;i++)
		{
			s=(Student)ois.readObject();
			System.out.println(s.rollno+", "+ s.name+", "+s.dept);			
		}

		ois.close();
		fi.close();
	}


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		myWrite();
		myRead();
	}

}

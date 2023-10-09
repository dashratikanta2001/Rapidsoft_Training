package com.serialization.withDataType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

class Student
{
	int rollno;
	String name;
	String dept;
}


public class MyWrite {

	private static void myWrite() throws IOException {
		// TODO Auto-generated method stub

		FileOutputStream fo = new FileOutputStream("testStudent2.txt");
		DataOutputStream d = new DataOutputStream(fo);
		Scanner sc = new Scanner(System.in);

		Student s = new Student();
		for(int i=0;i<4;i++)
		{
			System.out.println("Enter roll, name, dept and roll no of Student"+i);
			s.rollno=sc.nextInt();
			sc.nextLine();
			s.name=sc.nextLine();
			s.dept=sc.nextLine();
			
			d.writeInt(s.rollno);
			d.writeUTF(s.name);
			d.writeUTF(s.dept);
		}

		sc.close();
		d.close();
		fo.close();
	}

	private static void myRead() throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fi = new FileInputStream("testStudent2.txt");
		DataInputStream d = new DataInputStream(fi);
		Student s = new Student();

		for(int i=0;i<4;i++)
		{
			s.rollno = d.readInt();
			s.name = d.readUTF();
			s.dept = d.readUTF();
			System.out.println(s.rollno+", "+ s.name+", "+s.dept);			
		}

		d.close();
		fi.close();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		myWrite();
		myRead();
	}

}

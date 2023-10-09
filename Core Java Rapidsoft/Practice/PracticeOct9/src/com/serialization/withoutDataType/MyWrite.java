package com.serialization.withoutDataType;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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

		FileOutputStream fo = new FileOutputStream("testStudent.txt");
		PrintStream ps = new PrintStream(fo);
		Scanner sc = new Scanner(System.in);

		Student s = new Student();
		for(int i=0;i<4;i++)
		{
			System.out.println("Enter roll, name, dept and roll no of Student"+i);
			s.rollno=sc.nextInt();
			sc.nextLine();
			s.name=sc.nextLine();
			s.dept=sc.nextLine();

			ps.println(s.rollno);
			ps.println(s.name);
			ps.println(s.dept);
		}

		sc.close();
		ps.close();
		fo.close();
	}

	private static void myRead() throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fi = new FileInputStream("testStudent.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fi));

		Student s = new Student();

		for(int i=0;i<4;i++)
		{
			s.rollno = Integer.parseInt(br.readLine());
			s.name = br.readLine();
			s.dept = br.readLine();
			System.out.println(s.rollno+", "+ s.name+", "+s.dept);			
		}

		br.close();
		fi.close();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		myWrite();
		myRead();
	}

}

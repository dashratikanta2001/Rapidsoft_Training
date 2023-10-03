package practice.inner;

import java.io.*;

class Student implements Serializable{
	private static final long serialVersionUID = -8333913496395912741L;
	String studentName;
	int studentAge;

	public Student(String name, int age) {
		this.studentName = name;
		this.studentAge = age;
	}
}

public class SerializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s1 = new Student("Ratikanta Dash", 23);
		try {
			FileOutputStream fout = new FileOutputStream("test.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(s1);
			out.flush();
			System.out.println("Success");
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

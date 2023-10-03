package Assignment2.java;

class Student{
	public String name;
	public int age;
	public char grade;
	
	void setter(String name, int age, char grade)
	{
		this.name = name;
		this.age = age;
		this.grade = grade;
		getter();
	}
	
	void getter() {
		System.out.println("Hey "+name +" Your age is "+ age+" and your grade is "+grade);
	}
	void printDetails()
	{
		System.out.println("Name is : "+name);
		System.out.println("Age is : "+age);
		System.out.println("Grade is :" + grade);
	}
}

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student st = new Student();
		st.setter("Ratikanta", 22, 'A');

		st.printDetails();
	}

}

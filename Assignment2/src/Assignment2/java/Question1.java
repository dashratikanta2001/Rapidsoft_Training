package Assignment2.java;

class Person{
	public String name;
	public int age;
	
	 void getValue() {
		System.out.println("Hey "+name + " Your age is "+age );
	}
	 void setValue(String name, int age)
	{
		this.name =name;
		this.age = age;
	}
}

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person();
		
		p1.setValue("Ratikanta", 22);
		p1.getValue();
	}

}

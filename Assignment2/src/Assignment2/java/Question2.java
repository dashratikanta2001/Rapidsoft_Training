package Assignment2.java;

class PersonY{
	public String name;
	public int age;
	
	public PersonY(String name, int age)
	{
		this.name =name;
		this.age = age;
	}
	
	 void getValue() {
		System.out.println("Hey "+name + " Your age is "+age );
	}
	 
}

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonY p1 = new PersonY("Ratikanta", 22);
		p1.getValue();
	}

}

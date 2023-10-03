package practice.inner;

public class CloneableTest implements Cloneable{
	
	String name;
	String roll;
	int age;
	char sec;
	int i=0;
	
	CloneableTest (String name, String roll, int age, char sec)
	{
		this.name = name;
		this.roll = roll;
		this.age = age;
		this.sec = sec;
		
		display();
	}
	
	public void display()
	{
		System.out.println("Name: "+name);
		System.out.println("roll: "+roll);
		System.out.println("age: "+age);
		System.out.println("Sec: "+sec);
		System.out.println("i= "+i++);
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		CloneableTest c1 = new CloneableTest("Rati","1R212",23,'A');
		CloneableTest c2 = (CloneableTest)c1.clone();
		System.out.println();
//		c1.display();
		c2.display();

		
	}

}

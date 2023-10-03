package Assignment.java;

interface Vehicle{
	void engineStart();
	void engineStop();
}

class Car implements Vehicle{
	public void engineStart()
	{
		System.out.println("Car Engine Start");
		
	}
	
	public void engineStop()
	{
		System.out.println("Car Engine Stop");
	}
}

class Bike implements Vehicle{
	public void engineStart()
	{
		System.out.println("Bike Engine Start");
		
	}
	
	public void engineStop()
	{
		System.out.println("Bike Engine Stop");
	}
}

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car c = new Car();
		Bike b = new Bike();
		
		c.engineStart();
		c.engineStop();
		
		b.engineStart();
		b.engineStop();

	}

}

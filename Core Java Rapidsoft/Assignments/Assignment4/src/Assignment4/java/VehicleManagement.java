package Assignment4.java;

import java.util.Scanner;


class Vehicle{
	public String make="";
	public String model="";
	public int year;
	
	public Vehicle() {
		super();
	}
	Scanner sc = new Scanner(System.in);
	
	public Vehicle(String VehicleType)
	{		
		if(VehicleType.equalsIgnoreCase("car"))
		{
			Car c = new Car();
			c.enterCarDetails();
			
		}
		else if(VehicleType.equalsIgnoreCase("motorcycle"))
		{
			Motorcycle m = new Motorcycle();
			m.enterBikeDetails();
			
		}
		else if(VehicleType.equalsIgnoreCase("truck"))
		{
			Truck t = new Truck();
			t.enterTruckDetails();
			
		}
		else {
			System.out.println("Wrong Input");
		}
	}
	
	public void enterDetails(String[] m)
	{
		for(String s:m)
			System.out.println(s);
		String vh=sc.nextLine();
		String vehicle="";
		for(String s:m)
		{
			if(vh.equalsIgnoreCase(s))
			{
				vehicle=s;
			}
		}
		if(vehicle.equals(""))
		{
			System.out.println("Vehicle not found. Try again!!!"+ vehicle);
			System.exit(0);
		}
		else
		{
			make=vehicle;
		}
	}
	
	public int enterDetails()
	{
		return sc.nextInt();
	}
	
	public void showDetails(String type,int numberVehicle, int numberOfdays,int price)
	{
		System.out.println("\nHey you just booked the "+make+" "+ type+" of quantity "+numberVehicle+" for "+numberOfdays+" days ");
		System.out.println("So your booking amount is: "+price+" Rupees only.");
	}
}

class Car extends Vehicle{
	private String carMake[] = {"Tata","Mahindra", "BMW", "Audi"};
	private int numberVehicle,numberOfDays=1;
	
	public void enterCarDetails()
	{
		System.out.println("Enter Car maker name:");
		enterDetails(carMake);
		System.out.println("Enter number of vehicle:");
		numberVehicle = enterDetails();
		System.out.println("Enter number of days:");
		numberOfDays = enterDetails();
		calculateRentalCost();
	}
	
	public void calculateRentalCost()
	{
		int price = numberOfDays*numberVehicle*2000;
		showDetails("Car",numberVehicle,numberOfDays,price);
	}
	
}

class Motorcycle extends Vehicle{
	private String bikeMake[] = {"Hero","Honda","Bajaj","BMW"};
private int numberVehicle,numberOfDays=1;
	
	public void enterBikeDetails()
	{
		System.out.println("Enter Car maker name:");
		enterDetails(bikeMake);
		System.out.println("Enter number of vehicle:");
		numberVehicle = enterDetails();
		System.out.println("Enter number of days:");
		numberOfDays = enterDetails();
		calculateRentalCost();
	}
	
	public void calculateRentalCost()
	{
		int price = numberOfDays*numberVehicle*800;
		showDetails("Motorcycle",numberVehicle,numberOfDays,price);
	}
	
}

class Truck extends Vehicle{
	private String truckMake[]= {"Tata","Mahindra","Leyland","Eicher"};
private int numberVehicle,numberOfDays=1;
	
	public void enterTruckDetails()
	{
		System.out.println("Enter Car maker name:");
		enterDetails(truckMake);
		System.out.println("Enter number of vehicle:");
		numberVehicle = enterDetails();
		System.out.println("Enter number of days:");
		numberOfDays = enterDetails();
		calculateRentalCost();
	}
	
	public void calculateRentalCost()
	{
		int price = numberOfDays*numberVehicle*8500;
		showDetails("Truck",numberVehicle,numberOfDays,price);
	}
	
}


public class VehicleManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("We offer all type of vehicles for rent.\nPlease chose One: \nCar\nMotorcycle\nTruck");
		Scanner sc = new Scanner(System.in);
		String vehicleType = sc.nextLine();
		Vehicle v = new Vehicle(vehicleType);

	}

}

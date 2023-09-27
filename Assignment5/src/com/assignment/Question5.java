package com.assignment;

class Vehicle2{
	String brand="Mahindra";
	public Vehicle2(String brand)
	{
		System.out.println("Brand of the vehicle is :" +brand);
		
		System.out.println("The 2nd brand is "+this.brand);
	}
}

class Car2 extends Vehicle2{

	public Car2(String brand)
	{
		super(brand);
	}
	
}

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car2 c = new Car2("Tata");
	}

}

package com.assignment;

class Vehicle{
	public void startEngine()
	{
		System.out.println("Engine started");
	}
}

class Car extends Vehicle{
	public void startEngine()
	{
		System.out.println("Car Engine Started");
	}
}

public class Question2b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehicle v = new Car();
		v.startEngine();
	}

}

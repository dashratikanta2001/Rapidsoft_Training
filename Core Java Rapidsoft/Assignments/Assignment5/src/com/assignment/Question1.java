package com.assignment;

class Animal{
	public void sound()
	{
		System.out.println("Animal sound:");
	}
}

class Cat extends Animal{
	public void sound()
	{
		System.out.println("The cat sound like: MEOW");
	}
}

class Dog extends Animal{
	public void sound()
	{
		System.out.println("The dog sounds like: WOOF");
	}
}

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat c = new Cat();
		c.sound();
		
		Dog d = new Dog();
		d.sound();
	}

}

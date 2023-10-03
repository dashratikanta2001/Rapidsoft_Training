package Assignment3.java;

class Animal{
	void makeSound()
	{
		System.out.println("Animal makes a sound");
	}
}

class Cat extends Animal{
	void makeSound()
	{
		System.out.println("Cat sound is Meow")	;
	}
}

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cat c = new Cat();
		c.makeSound();
	}

}

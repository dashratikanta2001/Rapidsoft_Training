package com.java.threadAtm2;

class Atm{
	static int balance=5000;
	
	synchronized void checkBalance(String name)
	{
		System.out.println(name+" checking balance");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println("Current balance: "+balance+"\n");
	}
	
	synchronized void withdraw(String name, int amt)
	{
		System.out.println(name+" Withdrawing balance");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		if(amt>balance)
		{
			System.out.println("Insufficient Balance\n");
		}
		else
		{
			
			System.out.println("Name: "+ name);
			System.out.println("Amount Debited: "+ amt);
			System.out.println("Account Balance: "+ (balance-amt)+"\n");
		}
	}
}

class Customer extends Thread
{
	Atm atm;
	String name;
	int amount;
	
	Customer(Atm t, String name, int amt)
	{
		atm=t;
		this.name=name;
		this.amount=amt;
	}
	
	public void run()
	{
		useAtm();
	}
	
	void useAtm()
	{
		atm.checkBalance(name);
		atm.withdraw(name, amount);
	}
}

public class AtmHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Atm atm = new Atm();
		Customer c1 = new Customer(atm, "Ratikanta", 500);
		Customer c2 = new Customer(atm, "Asish", 1000);
		Customer c3 = new Customer(atm, "Anjan", 6000);
		c1.start();
		c2.start();
		c3.start();
	}

}

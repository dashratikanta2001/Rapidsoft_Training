package com.java.threadAtm;

import java.util.Scanner;

class Atm{
	 static int balance=5000;

	Scanner sc = new Scanner(System.in);
	 void checkBalance(String name)
	{
		System.out.println("Name: "+name+"\nBalance: "+balance);
	}
	
	 void withdraw(String name, int amt)
	{
		if(amt>balance)
		{
			System.out.println("Insufficient Balance");
		}
		else
		{
			balance-=amt;
			System.out.println("Name: "+ name);
			System.out.println("Amount Debited: "+ amt);
			System.out.println("Account Balance: "+ balance);
		}
	}
	
	 void useAtm(String n,int a)
	{
		char key=0;
		
		do
		{
			System.out.println("\nCheck Balance -------> 1");
			System.out.println("Withdraw Balance ----> 2");
			System.out.println("Exit ----------------> Press any key\n");
			key = sc.next().charAt(0);
//			System.out.println("Hello");
//			sc.next();
			switch (key) {
			case '1':
//				System.out.println("Enter Name\n");
//				this.name=sc.nextLine();
				checkBalance(n);
				break;
			case '2':
//				System.out.println("Enter Name");
//				this.name=sc.nextLine();
//				System.out.println("Enter Amount");
//				this.amount=sc.nextInt();
				withdraw(n, a);
				break;
			default:
//				System.exit(0);
//				break;
				System.out.println("Else");
			}
			
//			System.out.println("---\nCheck Balance ----> 1");
//			System.out.println("Withdraw Balance ----> 2");
//			System.out.println("Exit ----> Press any key");
			
		}while(key=='1'|| key=='2');
		
	}
}

class Customer extends Thread
{
	Atm atm;
	String name;
	int amount;
	
	Customer(Atm t,String n,int a)
	{
		atm=t;
		name=n;
		amount=a;
	}
	
	public void run()
	{
		atm.useAtm(name,amount);
	}
	
	
}

public class AtmHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Atm atm = new Atm();
		Customer c1 = new Customer(atm,"Rati",500);
		Customer c2 = new Customer(atm,"Kanta",1000);
		
		c1.start();
		c2.start();
		
	}

}

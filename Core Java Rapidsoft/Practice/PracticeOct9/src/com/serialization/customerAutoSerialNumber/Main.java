package com.serialization.customerAutoSerialNumber;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Customer implements Serializable
{
	private String custID;
	String name;
	String phno;
	private static int id=1;

	public Customer() {}

	public Customer(String n,String ph) {
		custID="C"+id;
		id++;
		name=n;
		phno=ph;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer ID: "+custID+
				"\nName: "+name+
				"\nPhone No: "+phno+"\n";
	}
}

public class Main {

	static void write() throws Exception
	{
		FileOutputStream fout = new FileOutputStream("Customer.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		Customer c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of customer:");
		int size = sc.nextInt();
		sc.nextLine();
		Customer cst[] = new Customer[size];

		objout.writeInt(size);
		for(int i=0;i<size;i++)
		{
			System.out.println("Enter name and phno of coustomer "+(i+1));
			cst[i]=new Customer(sc.nextLine(),sc.nextLine());
		}

		for(Customer x:cst)
			objout.writeObject(x);

		sc.close();
		objout.close();
		fout.close();
	}

	static void read() throws Exception
	{
		FileInputStream fin  = new FileInputStream("Customer.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);

		int size = objin.readInt();
		Customer cst[] = new Customer[size];

		System.out.println("To print all customer press 1:\n To search customer press 2:");
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<size;i++)
		{
			cst[i] = (Customer) objin.readObject();
		}
		switch(sc.nextLine())
		{
		case "1":
			for(Customer x:cst)
				System.out.println(x);
			break;
		case "2":
			System.out.println("Enter Customer name: ");
			String name =sc.nextLine();
			for(Customer x:cst)
			{
				if(name.equalsIgnoreCase(x.name))
					System.out.println(x);
			}
			break;
		default: System.out.println("Invalid number");
		}


		sc.close();
		objin.close();
		fin.close();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//		write();
		read();

	}

}

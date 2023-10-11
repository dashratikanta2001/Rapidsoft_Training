package com.collection.menuDriven;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
class Account implements Serializable
{
	String accno;
	String name;
	double balance;

	Account(){}

	Account(String a, String n, double b)
	{
		accno=a;
		name=n;
		balance=b;
	}
	@Override
	public String toString()
	{
		return "\nAccount No: "+accno+
				"\nName: "+name+
				"\nBalance: "+balance+"\n";
	}
}



public class SCCollection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Account acc=null;
		HashMap<String, Account> hm = new HashMap<>();

		try {
			FileInputStream fis = new FileInputStream("Account.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			int count = ois.readInt();
			for(int i=0;i<count;i++)
			{
				acc =(Account) ois.readObject();
				System.out.println(acc);
				hm.put(acc.accno, acc);
			}
			fis.close();
			ois.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		//		try {
		FileOutputStream fos = new FileOutputStream("Account.txt");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		int choice;
		String accno,name;
		double balance;

		do {
			String s="Enter Choice:"
					+ "\n1. Create Account"
					+ "\n2. Delete Account"
					+ "\n3. View Account"
					+ "\n4. View All Account"
					+ "\n5. Save Accounts"
					+ "\n6. Exit"
					+ "\nEnter your choice";
			System.out.println(s);
			choice = sc.nextInt();

			sc.nextLine();

			switch (choice) {
			case 1:	
				System.out.println("Enter Details Accno,Name,Balance:");
				accno=sc.nextLine();
				name = sc.nextLine();
				balance = sc.nextDouble();
				hm.put(accno, new Account(accno,name,balance));
				System.out.println("Account Created for "+name);

				break;
			case 2:	
				System.out.println("Enter Accno:");
				//						sc.nextLine();
				accno = sc.nextLine();
				hm.remove(accno);
				break;
			case 3:	
				System.out.println("Enter Accno:");
				accno = sc.nextLine();
				if(hm.get(accno)==null)
					System.out.println("\nAccount Number not available\n");
				acc=hm.get(accno);
				System.out.println(acc);
				break;
			case 4:	
				if(hm.isEmpty())
					System.out.println("\nNo data available\n");
				for(Account a:hm.values())
					System.out.println(a);
				break;
			case 5:	
				oos.writeInt(hm.size());
				for(Account a:hm.values())
					oos.writeObject(a);
				break;
			case 6:	
			default:
				if(choice!=5 && choice!=6)
				{
					System.out.println("Invalid Cridential\n");
					break;							
				}
				else
				{
					oos.writeInt(hm.size());
					for(Account a:hm.values())
						oos.writeObject(a);
					System.out.println("Thank you !!!!!!");
				}
				break;

			}
		}while(choice!=6);

		oos.flush();
		oos.close();
		fos.close();
		
	}

}

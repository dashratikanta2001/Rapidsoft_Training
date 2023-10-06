// 6) crate a project where you can input the balance in run time and use a static variable 
//where you can store the balance as 5000. if the user is input the value exceed than 5000 
//then create your own exception class as BalanceExceedException and print the message in 
//console as you're able to withdraw upto 5000.

package com.assignment10;

import java.util.Scanner;

class BalanceExceedException extends Exception
{
	public BalanceExceedException(String str)
	{
		super(str);
	}
}


public class Question6 {
	static int balance= 5000;
	
	static void withdrawBalance(int amt) throws BalanceExceedException
	{
		if(amt>balance)
		{
			throw new BalanceExceedException("you're able to withdraw upto 5000");
		}
		else
		{
			System.out.println("Amount withdraw successfully !!!!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Amount");
		
		try {
			withdrawBalance(sc.nextInt());
		} 
		catch (BalanceExceedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

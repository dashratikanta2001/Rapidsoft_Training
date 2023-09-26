package Assignment4.java;

class BankAccount{
	public long accno;
	public int balance;
}

class Saving extends BankAccount{
	public void withdraw(long accno, int balance)
	{
		if(balance>super.balance)
		{
			System.out.println("Insufficient Balance in your account.!!!!!");
		}
		else
		{
			super.balance -=balance; 
			System.out.println("Rupees "+balance+" has been debited from your Saving account number "+super.accno+" Successfully.");
			System.out.println("Current available balance: "+super.balance);
		}
	}
	
	public void deposite(long accno, int balance)
	{
		super.accno=accno;
		super.balance= balance; 
		System.out.println("Rupees "+super.balance+" is credited to your Saving account number "+super.accno+" Successfully.");
	}
}

class Checking extends BankAccount{
	public void withdraw(long accno, int balance)
	{
		if(balance>super.balance)
		{
			System.out.println("Insufficient Balance in your account.!!!!!");
		}
		else
		{
			super.balance -=balance; 
			System.out.println("Rupees "+balance+" has been debited from your Checking account number "+super.accno+" Successfully.");
			System.out.println("Current available balance: "+super.balance);
		}
	}
	
	public void deposite(long accno, int balance)
	{
		super.accno=accno;
		super.balance= balance; 
		System.out.println("Rupees "+super.balance+" is credited to your Checking account number "+super.accno+" Successfully.");
	}
}

public class BankManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Saving s = new Saving();
		s.deposite(123456789103l,9000);
		s.withdraw(123456789103l, 89009);
		
		System.out.println("___________________________________________________________");
		System.out.println("-----------------------------------------------------------");
		
		Checking c = new Checking();
		c.deposite(999956789103l,19000);
		c.withdraw(999956789103l, 8009);

	}

}

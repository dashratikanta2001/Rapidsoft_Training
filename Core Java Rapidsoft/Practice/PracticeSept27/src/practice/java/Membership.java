package practice.java;

interface Member{
	void callback();
}

class Store {
	Member mem[]= new Member[100];
	
	int count=0;
	
	void register(Member m)
	{
		mem[count++]=m;
	}
	
	void inviteSale()
	{
		for(int i=0;i<count;i++)
		{
			mem[i].callback();
		}
	}
}

class Customer implements Member{
	String name;
	Customer(String name)
	{
		this.name=name;
	}
	
	public void callback()
	{
		System.out.println("Ok, I will visit "+name);
	}
}

public class Membership {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer c1= new Customer("Ratikanta");
		Customer c2= new Customer("John");
		Store s=  new Store();
		s.register(c1);
		s.register(c2);
		s.inviteSale();
	}

}

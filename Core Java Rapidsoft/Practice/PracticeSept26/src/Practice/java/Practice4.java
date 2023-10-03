package Practice.java;

class Product{
	private String itemno;
	private String name;
	private double price;
	private short qty;
	
	public Product(String itemno, String name, double price, short qty)
	{
		this.itemno = itemno;
		this.name = name;
		setPrice(price);
		setQuantity(qty);
	}
	
	public String getItemno()
	{
		return itemno;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public short getQuantity()
	{
		return qty;
	}
	
	public void setPrice(double p)
	{
		price = p;
	}
	
	public void setQuantity(short q)
	{
		qty = q;
	}
	
}

class Customer{
	private String custId;
	private String name;
	private String address;
	private String phno;
	
	public Customer(String custId, String name)
	{
		this.custId = custId;
		this.name = name;
	}
	public Customer(String custId, String name,String add, String phno)
	{
		this.custId = custId;
		this.name = name;
		setAddress(add);
		setphno(phno);
	}
	
	public String getCustId()
	{
		return custId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getPhno()
	{
		return phno;
	}
	
	public void setAddress(String A)
	{
		address = A;
	}
	
	public void setphno(String p)
	{
		phno = p;
	}
	
	
}

public class Practice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product p = new Product("193A2", "Laptop", 45290, (short)5);

		Customer c = new Customer("1119A3E", "Ratikanta");
//		Customer c = new Customer("1119A3E", "Ratikanta","BBSR","123456789");
		
		c.setAddress("BBSR");
		c.setphno("123456789");
		
		System.out.println("Hey "+c.getName()+" your Id is "+c.getCustId()+" having address of "+c.getAddress()+" and phone number "+c.getPhno());
		
		System.out.println("And you are odering the product having the item no "+p.getItemno()+" and name "+p.getName()+" and having price "+p.getPrice()+" and quantity of "+p.getQuantity());
		
		System.out.println("So your total price is "+(p.getPrice()*p.getQuantity()));
	}

}

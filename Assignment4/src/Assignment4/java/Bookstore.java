package Assignment4.java;

class Book{
	public String title;
	public String author;
	public double price;
	
	public void print(double bPrice, double discount)
	{
		System.out.println("________________________________");
		System.out.println("Book Title: "+title);
		System.out.println("Book author: "+author);
		System.out.println("Book price: "+bPrice);
		System.out.println("Discount: "+discount);
		System.out.println("Final Price: "+price);
		System.out.println("________________________________");
	}
	
}

class FictionBook extends Book{
	double fbPrice = 500;
	double discount = 70;
	public void getDiscountedPrice(String title, String author)
	{
		this.title = title;
		this.author = author;
		price = fbPrice-discount;
		print(fbPrice,discount);
	}
}

class NonFictionBook extends Book{
	
	double fbPrice = 500;
	double discount = 70;
	public void getDiscountedPrice(String title, String author)
	{
		this.title = title;
		this.author = author;
		price = fbPrice-discount;
		print(fbPrice,discount);
	}
}

class EBook extends Book{
		
	double fbPrice = 500;
	double discount = 70;
	public void getDiscountedPrice(String title, String author)
	{
		this.title = title;
		this.author = author;
		price = fbPrice-discount;
		print(fbPrice,discount);
	}
}

public class Bookstore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FictionBook f = new FictionBook();
		f.getDiscountedPrice("Money Heist", "Professor");
		
		NonFictionBook n = new NonFictionBook();
		n.getDiscountedPrice("family Man", "Tiwari");
		
		EBook e = new EBook();
		e.getDiscountedPrice("The walking Dead", "Daryll");

	}

}

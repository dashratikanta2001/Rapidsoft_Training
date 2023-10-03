package practice.inner;

class StaticVariable{
	static double price =10;
	int a,b;
	
	static double display(int x)
	{
		switch(x)
		{
		case 1: return price*0.2;
		case 2: return price*0.5;
		case 3: return price+12;
		}
		return 0;		
	}
	static {
		System.out.println(price+" Price");
		
	}
}

public class StaticPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("The reflected price is: "+(int)StaticVariable.display(1));
		System.out.println(StaticVariable.price);

	}
	
	static {
		int m=17,n=9;
		if(m<n)
		{
			System.out.println("Static 1");
			System.exit(0);
		}
	}
	
}

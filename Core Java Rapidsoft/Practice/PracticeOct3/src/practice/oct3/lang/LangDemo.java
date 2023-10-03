package practice.oct3.lang;

class MyObject
{
	public String toString()
	{
		return "My Object";
	}
	
	public int hashCode()
	{
		return 100;
	}
	
	public boolean equals(Object o)
	{
		
		System.out.println(this.hashCode()+" , "+ o.hashCode());
		return this.hashCode()==o.hashCode();
	}
	
	// We can't Override the wait() and notify() because they are final method 
	
//	public void wait()
//	{
//		
//	}
//	
//	public void notify()
//	{
//		
//	}
}

public class LangDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyObject o1 = new MyObject();
		System.out.println(o1);
		System.out.println(o1.hashCode());
		System.out.println(o1.equals(o1));
	}

}

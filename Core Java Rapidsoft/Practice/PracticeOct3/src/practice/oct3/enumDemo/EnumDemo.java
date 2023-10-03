package practice.oct3.enumDemo;

enum Dept{
	CS("John1","Block A"),IT("John2","Block B"),CIVIL("John3","Block C"),ECE("John4","Block D");
	
	String head;
	String location;
	
	private Dept(String head, String Loc)
	{
//		System.out.println(this.name());
		this.head=head;
		this.location=Loc;
	}
	
//	public void Display()
//	{
//		System.out.println(this.name()+" "+ this.ordinal());
//	}
	
	public String getHeadName()
	{
		return head;
	}
	public String getLocation()
	{
		return location;
	}
}

public class EnumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dept d = Dept.CIVIL;
//		d.Display();
//		Dept list[] = Dept.values();
//		for(Dept x:list)
//			System.out.println(x);
		
		System.out.println(d.getHeadName());
		System.out.println(d.getLocation());
	}

}

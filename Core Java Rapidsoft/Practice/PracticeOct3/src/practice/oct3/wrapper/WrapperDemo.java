package practice.oct3.wrapper;

public class WrapperDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// Integer 
		
		int m1 = 15;
		
		Integer m2 = m1;
		Integer m3 = 15;
		
		Integer m4 = Integer.valueOf("123");
		Integer m5 = Integer.valueOf("A7", 16);		
		System.out.println(m2.compareTo(m1));
		
		System.out.println(m2.equals(m3));
		
		System.out.println(m2.toString());
		
		System.out.println(m4);
		
		System.out.println(m5);
		
		System.out.println(Integer.signum(123));
		
		System.out.println(Integer.toBinaryString(127));
	
		
		//Float
		System.out.println("\n------------FLOAT--------------\n");
		
		float a = 12.5f;
		Float b = 12.5f/0;
		Float c = (float)Math.sqrt(-1);
		
		System.out.println(b.equals(a)); 
		System.out.println(b.isInfinite());
		System.out.println(b==Float.POSITIVE_INFINITY);
		System.out.println(b== Float.NEGATIVE_INFINITY);
		System.out.println(c.isNaN());
		System.out.println(b!=Float.NaN);
		
		
		// Character
		
		System.out.println("\n------------CHARACTER--------------\n");
		
		Character cc ='A';
		
		
	}

}

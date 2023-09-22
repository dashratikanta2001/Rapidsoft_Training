package practice.sept22;

public class BitWiseOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int x = 0b1010;
//		int y;
//		
//		y=~x;
//		
//		System.out.println(String.format("%s",Integer.toBinaryString(x)));
//		System.out.println(String.format("%32s",Integer.toBinaryString(y)));
		
//		int a = 10, b = 15;
//		
//		a=a^b;
//		b=a^b;
//		a=a^b;
//		
//		System.out.println(a+" " +b);
		
		byte a=9, b=12;
		 byte c;
		 
		 c=(byte)(a<<4);
		 c = (byte) (c|b);
		 int x1=(c&0b11110000)>>4;
		 int x2=(c&0b00001111);
		 
		 System.out.println((c&0b11110000)>>4);
		 System.out.println((c&0b00001111));
		 System.out.println(x1 + "     " +x2);
		 System.out.println(String.format("%s",Integer.toBinaryString(x1)));
		 System.out.println(String.format("%s",Integer.toBinaryString(x2)));
		 System.out.println(String.format("%s",Integer.toBinaryString(c)));
		 System.out.println(c);
	
	}

}

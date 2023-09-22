package practice.sept22;

public class Datatype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a=5;
//		float b =2.5f;
//		char c = 'C';
//		System.out.println("Int value = "+ a + " Float Value = "+ b + " Char value = " + c);
		 int room_number;
		 float total$price;
		 char firstName;
		 byte x=-3;
		 int X=4;
		 byte b = 0xa;
		 long l = 999_999_999_999L;
		 float f = 2.9f;
		 char unicode = 0x20B9;
		 System.out.println(x+" "+l);
		 System.out.println("The Unicode character is : "+ unicode);
		 System.out.println(Integer.toBinaryString(x));
		 for(char c = 0x0B00; c<=0x0B7F;c++)
		 {
			 System.out.print(c+" ");
		 }
		 System.out.println();
		 
		 char ch='a';
		 short sh=15;
		 System.out.println(ch+sh);
		 
	}

}

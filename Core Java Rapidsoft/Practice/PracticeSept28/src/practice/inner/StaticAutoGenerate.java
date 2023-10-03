package practice.inner;

import java.util.Date;
import java.util.Scanner;

class Student3{
	private String rollno;
	private String name;
	private String classs;
	private String sec;
	
	private static int count=1;
	
	Student3()
	{
		rollno = generateRollno();	
	}
	public String get()
	{
		return rollno;
	}
	
	private String generateRollno()
	{
		Date d = new Date();
		String rl = "STD-"+(d.getYear()+1900)+"-"+count;
		count++;
		return rl;
	}
}

public class StaticAutoGenerate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		Student3 s[] = new Student3[101];
//		
		Scanner sc = new Scanner(System.in);
		char ans;
		int i=0;
		do {
			s[i]= new Student3();
			System.out.println(s[i++].get());			
			System.out.println("To continue press 1, to exit press any key1");
			ans=sc.next().charAt(0);
		}while(ans=='1');
		
		System.out.println("\n-------------------------------------------------------\n");
		for(int j=0;s[j]!=null;j++)
			{
				System.out.println(s[j++].get());
				System.out.println(s.length);
			}
	}

}

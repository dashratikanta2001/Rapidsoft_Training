package practice.sept22;

import java.util.Scanner;

public class CalculateArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		float base,height,area;
//		System.out.println("Enter Base of triangle");
//		base = sc.nextFloat();
//		System.out.println("Enter height of triangle");
//		height = sc.nextFloat();
//		
//		area = 0.5f*base*height;
//		System.out.println("Area of triangle is "+area);
		
		int a,b,c;
		float s;
		double area;
		
		System.out.println("Enter 3 side of the triangle");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		s = (a+b+c)/2f;
		area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		System.out.println("Area of the triangle is "+ area);
		
	}

}

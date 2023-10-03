package Assignment1.Sept25;

import java.util.Scanner;

public class ArrayElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Size of array");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the element of array");
		for(int i=0;i<size;i++)
		{
			arr[i] = sc.nextInt();
		}
		for(int i:arr)
		{
			System.out.print(i+",");
		}
	}

}

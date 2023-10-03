package practice.oct3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TryWithResources {
	
//	static FileInputStream fi;
//	static Scanner sc;
	
	static void Divide() throws Exception
	{
		
		
		try (FileInputStream fi = new FileInputStream("/home/rapidsoft/Documents/practice/PracticeOct3/src/practice/oct3/my.txt");Scanner sc = new Scanner(fi);){
//		sc = new Scanner(fi);
		int a=sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(a/0);
		}
//		finally {
//		fi.close();
//		sc.close();
//		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			Divide();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
//		int x = sc.nextInt();
//		System.out.println(x);
	}

}

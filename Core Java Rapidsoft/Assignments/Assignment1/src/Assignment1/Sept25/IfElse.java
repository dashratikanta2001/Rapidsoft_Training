package Assignment1.Sept25;

import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter URL");
		String url = sc.nextLine();
		String protocol = url.substring(0, url.indexOf(":"));
		
		if(protocol.equals("http"))
			System.out.println("Hypertext Transfer Protocol");
		else if(protocol.equals("ftp"))
			System.out.println("File Transfer Protocol");
		
		String ext = url.substring(url.lastIndexOf(".")+1);
		
		if(ext.equals("com"))
			System.out.println("commercial");
		else if(ext.equals("org"))
			System.out.println("Organization");
		else if(ext.equals("net"))
			System.out.println("network");
		
	}

}

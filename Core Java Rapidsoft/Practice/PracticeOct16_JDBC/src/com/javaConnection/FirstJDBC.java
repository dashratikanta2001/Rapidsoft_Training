package com.javaConnection;
import java.sql.*;

public class FirstJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//Load the driver
			//Creating a connection
			String url="jdbc:mysql://localhost:3306/ratiTest";
			String username="root";
			String password="Admin@123";
			Connection con = DriverManager.getConnection(url,username,password);
			
			if(con.isClosed())
			{
				System.out.println("Connection is closed");
			}
			else
			{
				System.out.println("Connection is created");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

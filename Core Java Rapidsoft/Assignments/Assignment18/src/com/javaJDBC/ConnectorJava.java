package com.javaJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorJava {

	private static Connection con;
	static Connection getConnection()
	{
		try {
			if(con==null)
			{
				String url = "jdbc:mysql://localhost:3306/ratiTest";
				String uname="root";
				String psw = "Admin@123";
				
				con = DriverManager.getConnection(url,uname,psw);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Database Connection Failed !!!!!!");
		}
		
		return con;
	}

}

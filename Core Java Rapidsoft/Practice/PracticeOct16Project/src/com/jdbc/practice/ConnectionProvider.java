package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	private static Connection con;
	public static Connection getConnection()
	{

		try {
			if(con==null)
			{
				String url="jdbc:mysql://localhost:3306/ratiTest";
				String username="root";
				String password="Admin@123";
//				Connection con = DriverManager.getConnection(url,username,password);

				con = DriverManager.getConnection(url,username,password);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		return con;
	}

}

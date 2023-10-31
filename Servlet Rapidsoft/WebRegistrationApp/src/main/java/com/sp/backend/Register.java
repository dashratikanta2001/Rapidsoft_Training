package com.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name1");
		String email = req.getParameter("email1");
		String pass = req.getParameter("pass1");
		String gender = req.getParameter("gender1");
		String city = req.getParameter("city1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ratiTest","root","Admin@123");
			
			PreparedStatement pst = con.prepareStatement("insert into register values(?,?,?,?,?)");
			
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, pass);
			pst.setString(4, gender);
			pst.setString(5, city);
			
			int count = pst.executeUpdate();
			if(count>0)
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:green' >User registered successfully</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
			else
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:red' >User not register due to some error</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color:red' >User not register due to some error</h3>"+"<br>"+"<h2>Exception Occured :"+e.getMessage()+"</h2>");
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
		
	}
}

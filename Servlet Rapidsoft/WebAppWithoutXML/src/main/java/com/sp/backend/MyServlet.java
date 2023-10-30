package com.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/submitForm")
public class MyServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("I am in servlet servide() method");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
		
		PrintWriter out = resp.getWriter();
		
		out.println("Name: "+name);
		out.println("Email: "+email);
	}
}

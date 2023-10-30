package com.sp.backend;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myLogin")
public class Login extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String email = req.getParameter("email");
//		String psw = req.getParameter("psw");
//		
//		if (email.equals("email@email.com") && psw.equals("email123")) {
//			System.out.println("Success");
//		}
//		else {
//			System.out.println("Failed");
//		}
		
		
//		//Search Parameter code with redirect
//		String mysearch = req.getParameter("search");
////		resp.sendRedirect("https://www.google.com");
//		resp.sendRedirect("https:www.google.com/search?q="+mysearch);
		
		
		
		String email = req.getParameter("email");
		String password = req.getParameter("psw");
		PrintWriter out = resp.getWriter();
		
		if (email.equals("email@email.com") && password.equals("123")) {
			
			req.setAttribute("name_key", "Ratikanta");
			
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			System.out.println("Success");
			rd.forward(req, resp);
		}
		else {
			resp.setContentType("text/html");
			out.print("<h3 style='color:red;'>Email id and password did't matched</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			System.out.println("Fail");
			rd.include(req, resp);
		}
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String email = req.getParameter("email");
//		String psw = req.getParameter("psw");
//		
//		if (email.equals("email@email.com") && psw.equals("email123")) {
//			System.out.println("Success");
//		}
//		else {
//			System.out.println("Failed");
//		}
//	}
//	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String psw = req.getParameter("psw");
		
		if (email.equals("email@email.com") && psw.equals("email123")) {
			System.out.println("Success");
		}
		else {
			System.out.println("Inside get");
			PrintWriter out = resp.getWriter();
			out.print(email);
		}
	}
}

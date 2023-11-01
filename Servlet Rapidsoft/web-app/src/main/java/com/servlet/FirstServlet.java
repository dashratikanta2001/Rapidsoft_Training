package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	ServletConfig conf;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Gointo destroy servlet object..g ");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.conf;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "This servlet is created by Ratikanta";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.conf = config;
		System.out.println("Creating object.....");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servicing.......");
		
		//set the content type of the response
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>This is my output from servlet method</h1>");
		out.println("<h1>Today data and time is: "+new Date().toString()+"</h1>");
	}

}

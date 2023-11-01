package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		
		//getting all the cookies..
		
		Cookie[] cookies = req.getCookies();
		boolean f= false;
		String name="";
		
		if(cookies==null)
		{
			out.println("<h1>You are new user. Go to homepage and submit your name ");
			return;
		}
		else {
			for (Cookie c : cookies) {
				String tname = c.getName();
				if(tname.equals("user_name"))
				{
					f=true;
					name=c.getValue();
				}
			}
		}
		
//		
//		 name = req.getParameter("name");
		
		if(f)
		{
		out.println("<h1>Hello, " + name + " welcome back to my website..........</h1>");
		out.println("<h1>Thank you </h1");
		}
		else {
			out.println("<h1>You are new user. Go to homepage and submit your name ");

		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

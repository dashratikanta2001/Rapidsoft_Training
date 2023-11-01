package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/S1")
public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	resp.setContentType("text/html");
    	PrintWriter out = resp.getWriter();
    	
    	int nn1 = Integer.parseInt(req.getParameter("n1"));
    	int nn2 = Integer.parseInt(req.getParameter("n2"));
    	
    	int s = nn1+nn2;
    	
    	// attribute ......
    	
    	req.setAttribute("sum", s);
    	
    	//request .... request dispatched
    	
    	RequestDispatcher rd = req.getRequestDispatcher("S2");
    	
    	rd.forward(req, resp);
	}

	public S1() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.mphasis;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class Demoproject extends GenericServlet {
	private static final long serialVersionUID = 1L;
     public int count,c;

	public void init(ServletConfig sc) {
		count=Integer.parseInt(sc.getInitParameter("count"));
		c=Integer.parseInt(sc.getInitParameter("c"));
	}
  
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<html>"+"<body>");
		pw.println("<h1>value of count</h2>"+count);
		pw.println("<html>"+"<body>");
		
		
		res.setContentType("text/html");
		pw.println("<html>"+"<body>");
		pw.println("<h1>value of count</h2>"+c);
		pw.println("<html>"+"<body>");
	}
	public void destroy() {
		
	}

}

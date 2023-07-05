package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("in init method with servletConfig");
	}
	/*public void init() {
		System.out.println("in init method");
	}*/
	public void doGet(HttpServletRequest req,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Hello World!!</h1>");
		out.println("<h2>Welcome to servlet programming</h2>");
	}
	public void destroy() {
		System.out.println("in destroy method");
	}

}

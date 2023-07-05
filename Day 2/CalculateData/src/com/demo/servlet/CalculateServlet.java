package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet{
	private int factorial(int num) {
		int f=1;
		for(int i=1;i<=num;i++) {
			f=f*i;
		}
		return f;
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		int num1=Integer.parseInt(req.getParameter("num1"));
		String btn=req.getParameter("btn");
		switch(btn) {
		case "add":
			int num2=Integer.parseInt(req.getParameter("num2"));
			out.println("<h3>Addition : "+(num1+num2)+"</h3>");
			break;
		case "factorial":
			int ans=factorial(num1);
			out.println("<h3>Factorial : "+ans+"</h3>");
		}
	}

}

package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String passwd=request.getParameter("pass");
		LoginService ls=new LoginServiceImpl();
		MyUser u=ls.validateUser(uname,passwd);
		if(u==null) {
			out.println("<h3>invalid credentials</h3>");
			
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}else {
			//out.println("<h3>Successful login</h3>");
			//to get new session or to get existing session
			System.out.println("in else part");
			HttpSession session=request.getSession();
			//session.setMaxInactiveInterval(10);
			if(session.isNew()) {
				System.out.println("session is new");
				session.setAttribute("user",u);
			}
			RequestDispatcher rd1=request.getRequestDispatcher("product");
			rd1.forward(request,response);
		}
		
	}

}

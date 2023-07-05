package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookiedata")
public class CookieDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("btn");
		RequestDispatcher rd=null;
		switch(btn) {
		case "add":
			rd=request.getRequestDispatcher("addnewcookie");
			break;
		case "del":
		    rd=request.getRequestDispatcher("delcookie");
			break;
		case "display":
			rd=request.getRequestDispatcher("display");
			break;
		}
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	

}

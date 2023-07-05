package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCookieServlet
 */
@WebServlet("/addnewcookie")
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String nm=request.getParameter("name");
		String val=request.getParameter("val");
		//create a new cookie object and write it to client
		Cookie c1=new Cookie(nm,val);
		response.addCookie(c1);
		out.println("<h4>Cookie added</h4>");
		RequestDispatcher rd=request.getRequestDispatcher("cookiedata.html");
		rd.include(request,response);
		
		
	}

}

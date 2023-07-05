package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet("/getdata")
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1=Integer.parseInt(request.getParameter("num1"));
		if((num1>=10) && (num1<=50)) {
			request.setAttribute("msg", "Your requirement is very low");
		}
		else {
			request.setAttribute("msg", "Your requirement is very high");
		}
		RequestDispatcher rd=request.getRequestDispatcher("calculate");
		rd.forward(request, response);
	}

}

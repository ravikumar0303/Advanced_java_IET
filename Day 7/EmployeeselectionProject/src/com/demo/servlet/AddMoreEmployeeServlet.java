package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AddMoreEmployeeServlet
 */
@WebServlet("/addmoreemp")
public class AddMoreEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno=Integer.parseInt(request.getParameter("dept"));
		EmployeeService es=new EmployeeServiceImpl();
		List<Employee> elist=es.getAllEmployees(deptno);
		request.setAttribute("elist", elist);
		request.setAttribute("dept",deptno);
	    RequestDispatcher rd=request.getRequestDispatcher("addmoreeemp.jsp");
	    rd.forward(request,response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Department;
import com.demo.service.DepartmentService;
import com.demo.service.DepartmentServiceImpl;

/**
 * Servlet implementation class DepartmentListServlet
 */
@WebServlet("/departments")
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentService ds=new DepartmentServiceImpl();
		List<Department> dlist=ds.getAllDepartment();
		request.setAttribute("dlist", dlist);
		RequestDispatcher rd=request.getRequestDispatcher("depatlistdisplay.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

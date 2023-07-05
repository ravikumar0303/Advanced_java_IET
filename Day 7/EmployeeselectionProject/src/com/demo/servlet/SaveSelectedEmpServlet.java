package com.demo.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Employee;

/**
 * Servlet implementation class SaveSelectedEmpServlet
 */
@WebServlet("/saveselected")
public class SaveSelectedEmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//it will save selected employees in set collection
		String[] selemp=request.getParameterValues("sel");
		int deptno=Integer.parseInt(request.getParameter("dept"));
		//check whether eset is exists 
		HttpSession session=request.getSession();
		Set<Employee> eset=(Set<Employee>)session.getAttribute("eset");
		//if set does not exists in the session then create a new set
		if(eset==null) {
			eset=new HashSet<>();
		}
		//add all selected employees in the eset
		//eset contains list of all previous selected employees
		//"123:sfsdf:34345"
		for(String emp :selemp) {
			String[] empdata=emp.split(":");
			Employee e=new Employee(Integer.parseInt(empdata[0]),empdata[1],deptno,Float.parseFloat(empdata[2]));
			eset.add(e);
		}
		session.setAttribute("eset", eset);
		RequestDispatcher rd=request.getRequestDispatcher("departments");
		System.out.println(eset);
		rd.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

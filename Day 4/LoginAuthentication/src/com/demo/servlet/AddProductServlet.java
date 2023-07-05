package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MyUser u=(MyUser)session.getAttribute("user");
		if(u!=null && u.getRole().equals("admin")) {
			//it will retrieve data from the form and add it in the table is user is valid
				int pid=Integer.parseInt(request.getParameter("pid"));
				String pname=request.getParameter("pname");
				int qty=Integer.parseInt(request.getParameter("qty"));
				float price=Float.parseFloat(request.getParameter("price"));
				Product p=new Product(pid,pname,qty,price);
				ProductService ps=new ProductServiceImpl();
				int n=ps.addProduct(p);
				RequestDispatcher rd=request.getRequestDispatcher("product");
				rd.forward(request, response);
		}else {
			//if user is invalid and reached to this page without login or login as user
			//then redirect to Login page
			System.out.println(u);
			System.out.println("not admin");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
		}
		
	}

}

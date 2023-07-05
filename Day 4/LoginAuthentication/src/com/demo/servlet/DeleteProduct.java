package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/delete")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//delete the product and send the control back to table
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		ProductService ps=new ProductServiceImpl();
		int n=ps.deleteById(pid);
		RequestDispatcher rd=request.getRequestDispatcher("product");
		rd.forward(request, response);
	}

	
}

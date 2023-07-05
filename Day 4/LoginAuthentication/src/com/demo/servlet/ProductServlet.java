package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MyUser u=(MyUser)session.getAttribute("user");
		//if user is valid and if the user is admin
		//then display table
		if(u!=null && u.getRole().equals("admin")) {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				ProductService ps=new ProductServiceImpl();
				List<Product> plist=ps.getAllProducts();
				out.println("<table border='2'><tr><th>Product id</th><th>Product name</th><th>Quantity</th><th>Price</th><th>action</th></tr>");
				for(Product p:plist) {
					out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td>");
					out.println("<td><a href='delete?pid="+p.getPid()+"'>delete</a>/<a href='edit?pid="+p.getPid()+"'>edit</a><td></tr>");
				}
				out.println("</table>");
				out.println("<a href='addproduct.html'>Add new Product</a>");
		}
		else {
			//if user is invalid and reached to this page without login or login as user
			//then redirect to Login page
			System.out.println(u);
			System.out.println("not admin");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

}

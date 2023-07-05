package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConverterServlet extends HttpServlet{
	private int rate;
	private String msg;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		rate=Integer.parseInt(config.getInitParameter("rate"));
		msg=config.getInitParameter("welcome");
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String dollar=request.getParameter("dollar");
		String inr=request.getParameter("inr");
		out.println("<h2>"+msg +"</h2>");
		out.println("<form action='convert' method='get'>");
		out.println("<table border='2'><tr><td>Dollar</td><td>INR</td></tr>");
		
		if(dollar.equals("")) {
			int d=Integer.parseInt(inr)/rate;
			out.println("<tr><td><input type='text' name='dollar' id='doll' value='"+d+"'></td>");
			out.println("<td><input type='text' name='inr' id='inr' value='"+inr+"'></td></tr>");
			//out.println("Dollar : "+d);
			
		}else {
			int d=Integer.parseInt(dollar)*rate;
			out.println("<tr><td><input type='text' name='dollar' id='doll' value='"+dollar+"'></td>");
			out.println("<td><input type='text' name='inr' id='inr' value='"+d+"'></td></tr>");
	
			//out.println("Inr : "+d);
		}
		out.println("<tr><td colspan='2'><button type='submit' name='btn' id='btn'>Convert</button><td></tr>");
		out.println("</table></form>");
		
		
		
	}

}

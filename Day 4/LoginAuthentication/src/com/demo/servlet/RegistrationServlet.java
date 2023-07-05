package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class RegistrationServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int uid=Integer.parseInt(request.getParameter("uid"));
		String nm=request.getParameter("nm");
		String addr=request.getParameter("addr");
		String uname=request.getParameter("uname");
		String passwd=request.getParameter("pass");
		String[] skill=request.getParameterValues("skill");
		String gender=request.getParameter("gender");
		String dt=request.getParameter("dt");
		String city=request.getParameter("city");
		//int uid, String name, String addr, String gender, String[] skills, Date dt, String city,
		//String uname
		LoginService ls=new LoginServiceImpl();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		RegisterUser ru=new RegisterUser(uid,nm,addr,gender,skill,ldt,city,uname);
		MyUser user=new MyUser(uname,passwd,"user");
		ls.addRegisterUser(ru, user);
		
		RequestDispatcher rd=request.getRequestDispatcher("Login.html");
		rd.forward(request, response);
	}

}

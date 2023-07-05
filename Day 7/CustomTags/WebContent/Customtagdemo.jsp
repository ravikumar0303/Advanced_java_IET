<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="mytag" uri="/calculate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   String num1="30";
   String num2="40";
%>
   <h1> Welcome to custom tags</h1>
   <mytag:mycalculate num1="<%=num1%>" num2="<%=num2%>"></mytag:mycalculate>
   <mytag:myhello fname="Kishori" lname="Khadilkar"></mytag:myhello>
</body>
</html>
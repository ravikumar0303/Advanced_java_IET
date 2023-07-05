<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="com.demo.beans.Product" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.html" %> 
	<%
	Product p=(Product)request.getAttribute("product");
	%>
	<form action="/Produmgnt_servlet_jsp/updateproduct" method="post">
	Product id : <input type="text" name="pid" id="pid" value="<%=p.getPid() %>" readonly> <br>
	Product name : <input type="text" name="pname" id="pname" value="<%=p.getPname() %>" ><br>
	Quantity : <input type="text" name="qty" id="qty" value="<%=p.getQty()%>"><br>
	Price <input type="text" name="price" id="price" value="<%=p.getPrice() %>" ><br>
	
	<button type="submit" name="btn" id="btn" value="update">Update Product</button>
	</form>
</body>
</html>
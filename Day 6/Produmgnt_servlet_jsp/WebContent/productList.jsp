<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.List,com.demo.beans.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.html" %> 
	<% 
	List<Product> plist=(List<Product>)request.getAttribute("plist");
	
	%>
	
	<table border="2">
	<tr><th>Product Id </th> 
	<th>Product Name </th> 
	<th>Product Quantity </th>
	<th>Price </th>
	<th></th>
	</tr>
	<%
		for(Product p:plist)
		{
	%>
		<tr>
		<td><%=p.getPid() %> </td>
		<td> <%=p.getPname() %></td>
		<td><%=p.getQty() %> </td>
		<td> <%=p.getPrice() %></td>
		<td>
		<a href="edit?pid=<%=p.getPid() %>">edit </a>/
		<a href="delete?pid=<%=p.getPid() %>">delete </a>
		</td>
		
		</tr>		
	<%
		}
	%>
	
	</table>
	<a href="addproduct.jsp">Add Product</a>
	

</body>
</html>
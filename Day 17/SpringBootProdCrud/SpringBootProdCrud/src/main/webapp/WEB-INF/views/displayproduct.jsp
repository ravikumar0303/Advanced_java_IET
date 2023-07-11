<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
   <tr>
      <th>Product pid</th>
   	  <th>Product name</th>
   	  <th>Product Qty</th>
   	  <th>Product price</th>
   	  
   </tr>
<c:forEach var="prod" items="${plist}">
    <tr>
      <td>${prod.pid}</td>
      <td>${prod.pname}</td>
      <td>${prod.qty}</td>
      <td>${prod.price}</td>
      <td>
         <a href="edit/${prod.pid}">edit </a>/
		<a href="delete/${prod.pid}">delete </a>
      </td>
    </tr>
 
 </c:forEach>
 </table><br>

 <a href="/addnewproduct">Add new product</a>&nbsp;&nbsp;
 <a href="logout">logout</a>
</body>
</html>
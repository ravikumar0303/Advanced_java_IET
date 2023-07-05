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
    <h3>It is confirmed that your project is selected successfully</h3>
    <table>
   <tr>
      <th>Employee no</th>
   	  <th>Employee name</th>
   	  <th>Employee sal</th>
   	  <th>Employee deptno</th>
   	  
   </tr>
<c:forEach var="emp" items="${eset}">
    <tr>
      <td>${emp.empno}</td>
      <td>${emp.ename}</td>
      <td>${emp.sal}</td>
      <td>${emp.deptno}</td>
      
    </tr>
 
 </c:forEach>
 </table><br>
 <a href="logout">logout</a>
</body>
</html>
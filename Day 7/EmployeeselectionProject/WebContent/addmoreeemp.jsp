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
<form action="saveselected" method="post">
<table>
   <tr>
      <th>Employee no</th>
   	  <th>Employee name</th>
   	  <th>Employee sal</th>
   	  <th>Employee deptno</th>
   	  <th>selection</th>
   </tr>
<c:forEach var="emp" items="${elist}">
    <tr>
      <td>${emp.empno}</td>
      <td>${emp.ename}</td>
      <td>${emp.sal}</td>
      <td>${emp.deptno}</td>
      <td>
      <input type="checkbox" name="sel" id="sel1" value="${emp.empno}:${emp.ename}:${emp.sal}">
      </td>
    </tr>
 
 </c:forEach>
   
</table>
   <input type="hidden" name="dept" id="dept" value="${dept}">
  <Button type="submit" name="btn" id="btn" value="add">Add selected</Button>
</form>
<a href="showselectedemp.jsp">Show selected</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.List,com.demo.beans.Department" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%
  List<Department> dlist=(List<Department>)request.getAttribute("dlist");
%> --%>
<select>
 <c:forEach var="dept" items="${dlist}">
    <option value="${dept.deptno}">${dept.dname}</option>
 
 </c:forEach>

</select>
 <a href="addmoreemp">Add More employee</a>
 <a href="selectedemp">Show selected</a> 
</body>
</html>
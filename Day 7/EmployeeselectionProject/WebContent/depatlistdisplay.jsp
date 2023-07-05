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
<form action="addmoreemp" method="get">
<select name="dept" id="dept" >
 <c:forEach var="dept" items="${dlist}">
    <option value="${dept.deptno}">${dept.dname}</option>
 
 </c:forEach>

</select>
 <button type="submit" name="btn" id="btn" value="btn">Add More employee</button>
 </form>
 <a href="showselectedemp.jsp">Show selected</a> 
 
 <a href="logout">logout</a>
</body>
</html>
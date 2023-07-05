<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="com.demo.beans.Employee"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--calls default constructor 
Person e1=new Employee()
  <jsp:useBean id="e1" class="com.demo.beans.Employee" type="com.demo.beans.Person"></jsp:useBean>
  --%>
  <jsp:useBean id="e1" class="com.demo.beans.Employee" scope="session"></jsp:useBean>
  <%-- <jsp:setProperty property="eid" name="e1" value='<%=request.getParameter("eid") %>'/> --%>
  <jsp:setProperty property="*" name="e1"></jsp:setProperty>
  
  Display data:
  Employee id: <jsp:getProperty property="eid" name="e1"></jsp:getProperty> ----- <%=e1.getEid() %>-----${e1.eid}
  Employee name : <jsp:getProperty property="ename" name="e1"></jsp:getProperty>-----${e1.ename}
  Employee salary: <jsp:getProperty property="sal" name="e1"/></jsp:getProperty>
  
  
</body>
</html>
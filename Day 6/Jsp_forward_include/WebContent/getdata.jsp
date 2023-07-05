<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <jsp:forward page="calculate">
       <jsp:param name="msg" value="This is welcom message"></jsp:param>
   </jsp:forward>
   <%--  <jsp:inclue page="calculate">
      
   </jsp:include> --%>
</body>
</html>
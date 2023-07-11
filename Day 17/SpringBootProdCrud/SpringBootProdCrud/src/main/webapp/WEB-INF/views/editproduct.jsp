<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/updateproduct" method="post" modelAttribute="product">
      Product Id: <form:input path="pid" id="pid"/><br>
      Product Name:<form:input path="pname" id="pname"/><br>
     <small><form:errors path="pname" cssClass="errormsg" /></small><br>
     Quantity : <form:input path="qty" id="qty"/><br>
     <small><form:errors path="qty" cssClass="errormsg" /></small><br>
     price: <form:input path="price" id="price"/><br>
     <small><form:errors path="price" cssClass="errormsg" /></small><br>
     <button type="submit" name="btn" id="btn" value="update">Update product</button>
  </form:form>
</body>
</html>
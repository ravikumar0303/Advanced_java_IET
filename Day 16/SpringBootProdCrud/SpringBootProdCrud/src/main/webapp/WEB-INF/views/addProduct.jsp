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
  <form:form action="/insertproduct" method="post" modelAttribute="product">
      Product Id: <form:input path="pid" id="pid"/>
      Product Name:<form:input path="pname" id="pname"/><br>
     <small><form:errors path="pname" cssClass="errormsg" /></small>
     Quantity : <form:input path="qty" id="qty"/>
     <small><form:errors path="qty" cssClass="errormsg" /></small>
     price: <form:input path="price" id="price"/>
     <small><form:errors path="price" cssClass="errormsg" /></small>
     <button type="submit" name="btn" id="btn" value="add">Add new product</button>
  </form:form>
</body>
</html>
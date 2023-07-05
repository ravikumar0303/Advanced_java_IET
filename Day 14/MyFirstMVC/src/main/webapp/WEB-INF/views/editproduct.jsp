<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="com.demo.beans.Product" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/MyFirstMVC/product/updateproduct" method="post">
	Product id : <input type="text" name="pid" id="pid" value="${prod.pid}" readonly> <br>
	Product name : <input type="text" name="pname" id="pname" value="${prod.pname}" ><br>
	Quantity : <input type="text" name="qty" id="qty" value="${prod.qty}"><br>
	Price <input type="text" name="price" id="price" value="${prod.price}" ><br>
	
	<button type="submit" name="btn" id="btn" value="update">Update Product</button>
	</form>
</body>
</html>
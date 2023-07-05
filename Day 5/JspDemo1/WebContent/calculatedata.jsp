<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.Date" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- this is declarative code will be added outside doget in servlet --%>
<%!

   public int factorial(int num){
	  int f=1;
	  for(int i=1;i<=num;i++){
		  f=f*i;
	  }
	  return f;
   }

%>
  Date: <% out.println(new Date()); %>
  <%
     int n1=Integer.parseInt(request.getParameter("n1"));
     String btn=request.getParameter("btn");
     switch(btn){
     case "add":
    	 int n2=Integer.parseInt(request.getParameter("n2"));
    	 out.println("Addition : "+(n1+n2));
    	 break;
     case "factorial":
    	 int ans=factorial(n1);
    	 out.println("Factorial : "+ans);
     }
  
  %>
</body>
</html>
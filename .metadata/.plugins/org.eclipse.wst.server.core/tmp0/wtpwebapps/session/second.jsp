<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
<body>  
<%   
  
String name=(String)session.getAttribute("user");  
out.print("Hello "+name);  
  
%>  
</body>  
</html>  
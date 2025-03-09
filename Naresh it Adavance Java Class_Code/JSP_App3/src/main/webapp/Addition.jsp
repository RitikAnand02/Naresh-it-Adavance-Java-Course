<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<% 
int v1 = Integer.parseInt(request.getParameter("v1")); 
int v2 = Integer.parseInt(request.getParameter("v2")); 
String nm = request.getParameter("nm"); 
int v3 = v1+v2; 
out.println("Param-Value:"+nm+"<br>"); 
out.println("Sum:"+v3+"<br>"); 
%> 
<jsp:include page="input.html"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.test.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body> 
<jsp:useBean id="ob" class="com.test.ProductBean" 
scope="session"/> 
<jsp:setProperty property="code" param="code" 
name="ob"/> 
<jsp:setProperty property="name" param="name" 
name="ob"/> 
<jsp:setProperty property="price" param="price" 
name="ob"/> 
<jsp:setProperty property="qty" param="qty" name="ob"/> 
<% 
out.println("Producr details loaded to Bean-Object..<br>"); 
%> 
<a href="View.jsp">ViewDetailsFromBean</a> 
</body>
</html>
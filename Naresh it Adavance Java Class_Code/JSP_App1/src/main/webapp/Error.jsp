<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
out.println("Enter only Integer values...<br>"); 
%> 
<%= exception %> 
<br> 
<%@ include file="input.html"%> 
</body>
</html>
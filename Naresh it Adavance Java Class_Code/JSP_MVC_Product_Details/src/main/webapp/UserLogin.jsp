<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<% 
UserBean ub = (UserBean)session.getAttribute("ub"); 
out.println("Welcome User "+ub.getfName()+"<br>"); 
%> 
<a href="view">ViewProducts</a> 
<a href="logout">Logout</a> 
</body>
</html>
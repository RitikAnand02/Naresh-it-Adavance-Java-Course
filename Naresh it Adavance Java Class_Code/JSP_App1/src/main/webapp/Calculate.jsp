<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
int fact; 
int factorial(int n) 
{ 
 fact=1; 
 for(int i=n;i>=1;i--) 
 { 
  fact=fact*i; 
 } 
 return fact; 
} 
%> 
<% 
  int n = Integer.parseInt(request.getParameter("v")); 
  int res = factorial(n); 
  out.println("Factorial:"+res+"<br>"); 
%> 
<%@ include file="input.html"%>
</body>
</html>
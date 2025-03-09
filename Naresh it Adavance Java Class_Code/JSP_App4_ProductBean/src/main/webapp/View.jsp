<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.test.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ob" type="com.test.ProductBean" 
scope="session"/> 
ProductCode:<jsp:getProperty property="code" 
name="ob"/><br> 
ProductName:<jsp:getProperty property="name" 
name="ob"/><br> 
ProductPrice:<jsp:getProperty property="price" 
name="ob"/><br> 
ProductQty:<jsp:getProperty property="qty" 
name="ob"/><br>
</body>
</html>
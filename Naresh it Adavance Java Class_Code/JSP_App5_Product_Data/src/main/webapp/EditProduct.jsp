<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
AdminBean ab = (AdminBean)session.getAttribute("abean"); 
ProductBean pb = (ProductBean)request.getAttribute("pbean"); 
out.println("Page Belongs to Admin : "+ab.getfName()+"<br>"); 
%> 
<form action="update" method="post"> 
<input type="hidden" name="pcode" value=<%= pb.getCode() %>> 
ProductPrice:<input type="text" name="price" value=<%= pb.getPrice() %>><br> 
ProductQty:<input type="text" name="qty" value=<%= pb.getQty() %>><br> 
<input type="submit" value="UpdateProduct"> 
</form> 
</body>
</html>
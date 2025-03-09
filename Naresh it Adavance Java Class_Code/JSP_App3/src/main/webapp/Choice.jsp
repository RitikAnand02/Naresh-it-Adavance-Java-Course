<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String s1 = request.getParameter("s1"); 
if(s1.equals("Add")){ 
 %> 
 <jsp:forward page="Addition.jsp"> 
    <jsp:param value="<%=200 %>" name="nm"/> 
 </jsp:forward> 
 <% 
}else{ 
%> 
<jsp:forward page="Subtraction.jsp"> 
  <jsp:param value="500" name="nm"/> 
</jsp:forward> 
<%  
} 
%>
</body>
</html>
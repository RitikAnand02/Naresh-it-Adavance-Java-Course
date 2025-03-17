<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
 <% pageContext.setAttribute("fName","Raju"); %>  
 <c:set var="name" value="${param.name} "/>  
 WELCOME : <c:out value="${name}"/><br>  
 <c:set var="a" value="${applicationScope.a}" />  
 <c:set var="b" value="${sessionScope.b}" />  
 <c:set var="c" value="${requestScope.c}" />  
 <c:set var="d" value="${pageScope.fName}" />    
 ContextVal:<c:out value="${a}"/><br>    
 SessionVal:<c:out value="${b}"/><br>    
 RequestVal:<c:out value="${c}"/><br>    
 PageVal:<c:out value="${d}"/><br>
</body>
</html>
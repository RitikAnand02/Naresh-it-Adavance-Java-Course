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
<c:set var="n" value="${param.str}" />  
<c:forEach var="j" begin="1" end="5">     
<c:out value="${n}"/><p>   
</c:forEach>   
<c:forTokens items="${param.str}" delims=" " var="name">      
<c:out value="${name}"/><p>   
</c:forTokens> 
</body>
</html>
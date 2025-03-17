<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> 
table, th, td { 
  border: 1px solid; 
} 
</style> 
</head>
<body>
 <table> 
  <tr> 
 <td>UserID</td> 
 <td><%=request.getParameter("userid") %></td> 
  </tr> 
  <tr> 
 <td>PassId</td> 
 <td><%=request.getParameter("passid") %></td> 
  </tr> 
  <tr> 
    <td>UserName</td> 
    <td><%=request.getParameter("username") %></td> 
  </tr> 
  <tr> 
    <td>Address</td> 
    <td><%=request.getParameter("address") %></td> 
  </tr> 
  <tr> 
    <td>Country</td> 
    <td><%=request.getParameter("country") %></td> 
  </tr> 
  <tr> 
    <td>ZIP</td> 
    <td><%=request.getParameter("zip") %></td> 
  </tr> 
  <tr> 
    <td>MailId</td> 
    <td><%=request.getParameter("email") %></td> 
  </tr> 
  <tr> 
    <td>Gender</td> 
    <td><%=request.getParameter("gen") %></td> 
 
  </tr> 
  <tr> 
    <td>Languages</td> 
    <td><% 
    String lang[] = request.getParameterValues("lan"); 
    for(String str : lang) 
    { 
     %> 
     <%=str %> 
     <% 
    } 
    %> 
    </td> 
  </tr> 
  <tr> 
    <td>Description</td> 
    <td><%=request.getParameter("desc") %></td> 
  </tr> 
  </table> 
</body>
</html>
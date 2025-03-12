<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.test.*"%>
<!DOCTYPE html>
<html>
<head>
<style> 
table, th, td { 
  border: 1px solid black; 
  border-collapse: collapse; 
} 
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
UserBean ub = (UserBean)session.getAttribute("ub"); 
ArrayList<ProductBean> al =(ArrayList<ProductBean>)session.getAttribute("al"); 
out.println("page of "+ub.getfName()+"<br>"); 
if(al.size()==0){ 
 out.println("Products not available...<br>"); 
}else{ 
Iterator<ProductBean> it = al.iterator(); 
%>  
  <table> 
   <tr> 
    <th>CODE</th> 
    <th>NAME</th> 
    <th>PRICE</th> 
    <th>QTY</th>     
  </tr> 
  <% 
  while(it.hasNext()){ 
  ProductBean pb = (ProductBean)it.next(); 
  %> 
  <tr> 
  <td><%=pb.getCode() %></td> 
 <td><%=pb.getName() %></td> 
 <td><%=pb.getPrice() %></td> 
 <td><%=pb.getQty() %></td> 
 <td><a 
href="buy?code=<%=pb.getCode()%>">Buy</a></td> 
  </tr> 
   <% 
 } 
 %> 
 </table> 
 <a href="logout">Logout</a> 
 <% 
} 
%> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String fN = (String)request.getAttribute("fname"); 
ArrayList<CustomerBean> al = 
(ArrayList<CustomerBean>)request.getAttribute("alist"); 
out.println("Page belongs to : "+fN+"<br>"); 
if(al.size()==0){ 
 out.println("No Customers available...<br>"); 
}else{ 
 Iterator<CustomerBean> it = al.iterator(); 
 while(it.hasNext()){ 
  CustomerBean cb = (CustomerBean)it.next(); 
  out.println(cb.getId()+"&nbsp&nbsp" 
    +cb.getName()+"&nbsp&nbsp" 
    +cb.getCity()+"&nbsp&nbsp" 
    +cb.getmId()+"&nbsp&nbsp" 
    +cb.getPhNo()+"<br>"); 
 } 
} 
%> 
<a href="logout">Logout</a> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
AdminBean ab = (AdminBean)session.getAttribute("abean"); 
ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("alist"); 
out.println("Page Belongs to Admin : "+ab.getfName()+"<br>"); 
if(al.size()==0){ 
out.println("Prodcuts not available...<br>"); 
}else{ 
Iterator<ProductBean> it = al.iterator(); 
while(it.hasNext()){ 
ProductBean pb = (ProductBean)it.next();  
out.println(pb.getCode()+"&nbsp&nbsp" 
+pb.getName()+"&nbsp&nbsp" 
+pb.getPrice()+"&nbsp&nbsp" 
+pb.getQty()+"&nbsp&nbsp" 
+"<a href='edit?pcode="+pb.getCode()+"'>Edit</a>"+"&nbsp&nbsp" 
+"<a href='delete?pcode="+pb.getCode()+"'>Delete</a>"+"<br>"); 
} 
} 
%> 
<a href="Product.html">AddProduct</a> 
<a href="logout">Logout</a> 
</body>
</html>
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
String eId = request.getParameter("eid"); 
String eName = request.getParameter("ename"); 
String eDesg = request.getParameter("edesg"); 
int bSal = Integer.parseInt(request.getParameter("bsal")); 
float hra = 0.93F*bSal; 
float da = 0.63F*bSal; 
float totSal = bSal+hra+da; 
out.println("Emp-Id:"+eId+"<br>"); 
out.println("Emp-Name:"+eName+"<br>"); 
out.println("Emp-Desg:"+eDesg+"<br>"); 
out.println("Emp-BSal:"+bSal+"<br>"); 
out.println("Emp-HRA:"+hra+"<br>"); 
out.println("Emp-DA:"+da+"<br>"); 
out.println("Emp-TotSal:"+totSal+"<br>"); 
%> 
<%@include file="employee.html" %> 
</body>
</html>
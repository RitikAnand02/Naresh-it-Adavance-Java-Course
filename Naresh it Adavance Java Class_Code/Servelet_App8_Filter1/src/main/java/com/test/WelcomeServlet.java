package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
@WebServlet("/log") 
public class WelcomeServlet extends HttpServlet{ 
protected void doPost(HttpServletRequest req, 
HttpServletResponse res)throws ServletException, 
IOException{ 
PrintWriter pw = res.getWriter(); 
res.setContentType("text/html"); 
String fName = (String)req.getAttribute("fName"); 
String lName = (String)req.getAttribute("lName"); 
String addr = (String)req.getAttribute("addr"); 
String mId = (String)req.getAttribute("mid"); 
String phNo = (String)req.getAttribute("phno"); 
pw.println("Welcome User : "+fName+"<br>"); 
pw.println(fName+"&nbsp&nbsp&nbsp" 
+lName+"&nbsp&nbsp&nbsp" 
+addr+"&nbsp&nbsp&nbsp" 
+mId+"&nbsp&nbsp&nbsp" 
+phNo+"<br>"); 
RequestDispatcher rd = 
req.getRequestDispatcher("login.html"); 
rd.include(req, res); 
} 
} 

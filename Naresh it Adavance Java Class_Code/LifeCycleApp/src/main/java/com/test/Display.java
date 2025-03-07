package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
@WebServlet("/dis") 
public class Display extends HttpServlet 
{ 
   public int x; 
   public int y; 
   public Display() 
   { 
   x++;  
    y++; 
   } 
   
@Override 
public void init()throws ServletException 
{ 
	x++; 
	y++; 
} 

@Override 
protected void doPost(HttpServletRequest req, 
HttpServletResponse res)throws ServletException, 
IOException{ 
PrintWriter pw = res.getWriter(); 
res.setContentType("text/html"); 
String uName = req.getParameter("uname"); 
pw.println("Welcome User : "+uName+"<br>"); 
pw.println("The value of x : "+x+"<br>"); 
pw.println("The value of y : "+y+"<br>");
} 
 
@Override 
public void destroy() 
{ 
	x=100; 
	y=200; 
} 
} 

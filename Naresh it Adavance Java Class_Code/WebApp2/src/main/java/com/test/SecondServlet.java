package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
@WebServlet("/second") 
public class SecondServlet extends HttpServlet{ 
@Override 
protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
{ 
PrintWriter pw = res.getWriter(); 
res.setContentType("text/html"); 
String uName = req.getParameter("uname"); 
String mId = req.getParameter("mid"); 
pw.println("****SecondServlet****<br>"); 
pw.println("UserName:"+uName+"<br>"); 
pw.println("MailId:"+mId); 
} 
}

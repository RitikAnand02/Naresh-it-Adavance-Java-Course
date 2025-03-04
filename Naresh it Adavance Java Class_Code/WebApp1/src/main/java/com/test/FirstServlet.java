package com.test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
@WebServlet("/first") 
public class FirstServlet extends HttpServlet{ 
@Override 
protected void doPost(HttpServletRequest req, 
HttpServletResponse res)throws ServletException, 
IOException{ 
	String uName = req.getParameter("uname"); 
	String mId = req.getParameter("mid"); 
res.sendRedirect 
("http://localhost:8082/WebApp2/second?uname="+uName 
+"&mid="+mId); 
} 
 
}

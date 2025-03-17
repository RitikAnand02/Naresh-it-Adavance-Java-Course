package com.test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg") 
public class RegServlet extends HttpServlet{ 
protected void doPost(HttpServletRequest req, 
HttpServletResponse res)throws ServletException, 
IOException{ 
/* PrintWriter pw = res.getWriter(); 
res.setContentType("text/html"); 
String userId = req.getParameter("userid"); 
String passId = req.getParameter("passid"); 
String userName = req.getParameter("username"); 
String addr = req.getParameter("address");    
String country = req.getParameter("country"); 
String zip = req.getParameter("zip"); 
String mId = req.getParameter("email"); 
String gen = req.getParameter("gen"); 
String lang[] = req.getParameterValues("lan");
 
   String desc = req.getParameter("desc"); 
   pw.println(userId+"<br>"); 
   pw.println(passId+"<br>"); 
   pw.println(userName+"<br>"); 
   pw.println(addr+"<br>"); 
   pw.println(country+"<br>"); 
   pw.println(zip+"<br>"); 
   pw.println(mId+"<br>"); 
   pw.println(gen+"<br>"); 
   for(String l : lang) 
   { 
    pw.println(l+"<br>"); 
   } 
   pw.println(desc+"<br>");*/ 
   req.getRequestDispatcher("ShowDetails.jsp").forward(req, res); 
  } 
}

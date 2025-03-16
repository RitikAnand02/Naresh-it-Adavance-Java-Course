package com.test;

import java.io.*; 
 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
import jakarta.servlet.annotation.*; 
@SuppressWarnings("serial") 
@WebServlet("/logout") 
public class LogoutServlet extends HttpServlet 
{ 
 @Override 
   protected void doGet(HttpServletRequest req,HttpServletResponse res)throws 
   ServletException,IOException 
   { 
   Cookie c[] = req.getCookies(); 
   if(c==null) { 
    req.setAttribute("msg", "Session Expired...<br>"); 
    req.getRequestDispatcher("Msg.jsp").forward(req, res); 
   }else { 
    c[0].setMaxAge(0); 
    res.addCookie(c[0]); 
    req.setAttribute("msg", "User Logged Out Successfully...<br>"); 
    req.getRequestDispatcher("Logout.jsp").forward(req, res); 
   } 
   } 
} 

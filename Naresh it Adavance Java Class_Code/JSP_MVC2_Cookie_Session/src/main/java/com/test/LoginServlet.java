package com.test;

import java.io.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
import jakarta.servlet.annotation.*; 
@SuppressWarnings("serial") 
@WebServlet("/log") 
public class LoginServlet extends HttpServlet 
{ 
 @Override 
   protected void doPost(HttpServletRequest req,HttpServletResponse res)throws 
   ServletException,IOException 
   { 
    String uN = req.getParameter("uname"); 
    String pW = req.getParameter("pword"); 
    String fN = new LoginDAO().login(uN, pW); 
    if(fN==null) { 
     req.setAttribute("msg","Invalid Login Process...<br>"); 
     req.getRequestDispatcher("Msg.jsp").forward(req, res); 
    }else { 
     req.setAttribute("fName", fN); 
     Cookie ck = new Cookie("fname",fN); 
     res.addCookie(ck);//Adding Cookie Object to response 
     req.getRequestDispatcher("LoginSuccess.jsp").forward(req, res); 
    } 
 
} 
}
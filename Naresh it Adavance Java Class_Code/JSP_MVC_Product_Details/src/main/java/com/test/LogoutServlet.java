package com.test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial") 
@WebServlet("/logout") 
public class LogoutServlet extends HttpServlet{ 
 @Override 
  protected void doGet(HttpServletRequest req, 
    HttpServletResponse res)throws ServletException, 
  IOException{ 
   HttpSession hs = req.getSession(false); 
   if(hs==null) { 
   req.setAttribute("msg","Session expired...<br>"); 
   }else { 
    hs.removeAttribute("ub"); 
    hs.removeAttribute("al"); 
    hs.invalidate();//session destroyed  
    req.setAttribute("msg","logged out Successfully...<br>"); 
   } 
   req.getRequestDispatcher("Response.jsp").forward(req, res); 
  } 
} 

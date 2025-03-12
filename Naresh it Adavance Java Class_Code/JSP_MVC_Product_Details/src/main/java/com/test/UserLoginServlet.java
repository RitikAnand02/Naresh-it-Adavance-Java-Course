package com.test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial") 
@WebServlet("/user") 
public class UserLoginServlet extends HttpServlet{ 
  protected void doPost(HttpServletRequest req, 
    HttpServletResponse res)throws ServletException, 
  IOException{ 
   UserBean ub = new UserLoginDAO().login(req); 
   if(ub==null) { 
    req.setAttribute("msg","Invalid Login Process..<br>"); 
    req.getRequestDispatcher("Response.jsp").forward(req, res); 
   }else { 
    HttpSession hs = req.getSession(); 
    hs.setAttribute("ub", ub); 
    req.getRequestDispatcher("UserLogin.jsp").forward(req, res); 
   } 
  } 
} 

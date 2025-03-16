package com.test;

import java.io.*; 
import java.util.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
import jakarta.servlet.annotation.*; 
@SuppressWarnings("serial") 
@WebServlet("/cview") 
public class ViewCustomersServlet extends HttpServlet 
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
     String fN = c[0].getValue(); 
     req.setAttribute("fname", fN); 
     ArrayList<CustomerBean> al = new ViewCustomersDAO().retrieve(); 
     req.setAttribute("alist", al); 
     req.getRequestDispatcher("ViewCustomers.jsp").forward(req, res); 
 
    } 
   } 
} 
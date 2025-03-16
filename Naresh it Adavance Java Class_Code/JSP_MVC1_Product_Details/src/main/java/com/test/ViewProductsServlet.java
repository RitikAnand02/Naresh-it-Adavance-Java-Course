package com.test;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial") 
@WebServlet("/view") 
public class ViewProductsServlet extends HttpServlet{ 
@Override 
protected void doGet(HttpServletRequest req, 
HttpServletResponse res)throws ServletException, 
IOException{ 
HttpSession hs = req.getSession(false); 
if(hs==null) { 
req.setAttribute("msg", "Session expired...<br>"); 
req.getRequestDispatcher("Response.jsp").forward(req, res); 
}else { 
ArrayList<ProductBean> al =  
new ViewProductsDAO().retrieve(); 
 
   hs.setAttribute("al", al); 
      req.getRequestDispatcher("ViewProducts.jsp").forward(req, res);   
  } 
 } 
} 
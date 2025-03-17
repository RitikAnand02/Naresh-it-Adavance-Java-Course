package com.test;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial") 
@WebServlet("/dis") 
public class ControllerServlet extends HttpServlet{ 
   @ Override 
   public void doPost(HttpServletRequest req, 
                     HttpServletResponse res) 
   throws ServletException,IOException{ 
 ServletContext sct = this.getServletContext(); 
HttpSession hs = req.getSession(); 
sct.setAttribute("a",100); 
hs.setAttribute("b",200); 
req.setAttribute("c", 300); 
RequestDispatcher rd = req.getRequestDispatcher("Display.jsp"); 
rd.forward(req,res); 
   } 
} 
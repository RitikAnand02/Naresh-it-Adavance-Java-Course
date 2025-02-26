package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial") 
@WebServlet("/add") 
public class AddProductServlet extends HttpServlet{ 
@Override 
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{ 
PrintWriter pw = res.getWriter(); 
res.setContentType("text/html"); 
HttpSession hs = req.getSession(false);
if(hs==null) {  
pw.println("Session expired...<br>"); 
RequestDispatcher rd =  
req.getRequestDispatcher("home.html"); 
rd.include(req, res); 
}else { 
AdminBean ab = (AdminBean)hs.getAttribute("ab"); 
ProductBean pb = new ProductBean(); 
pb.setCode(req.getParameter("code")); 
pb.setName(req.getParameter("name")); 
pb.setPrice(Float.parseFloat(req.getParameter("price"))); 
pb.setQty(Integer.parseInt(req.getParameter("qty"))); 
int k = new AddProductDAO().add(pb); 
pw.println("Page belongs to "+ab.getfName()+"<br>"); 
RequestDispatcher rd =  
req.getRequestDispatcher("link1.html"); 
rd.include(req, res); 
if(k>0) { 
pw.println("<br>Product added Successfully...");
} 
} 
} 
}

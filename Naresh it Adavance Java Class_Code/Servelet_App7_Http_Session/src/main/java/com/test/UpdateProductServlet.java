package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial") 
@WebServlet("/update") 
public class UpdateProductServlet extends HttpServlet{ 
@SuppressWarnings("unchecked") 
protected void doPost(HttpServletRequest req, 
HttpServletResponse res)throws ServletException, 
IOException{ 
PrintWriter pw = res.getWriter(); 
res.setContentType("text/html"); 
HttpSession hs = req.getSession(false); 
if(hs==null) { 
pw.println("Session Expired...<br>"); 
RequestDispatcher rd =  
req.getRequestDispatcher("home.html"); 
rd.include(req, res); 
}else { 
AdminBean ab = (AdminBean)hs.getAttribute("ab"); 
pw.println("Page belongs to "+ab.getfName()+"<br>"); 
ArrayList<ProductBean> al =  
(ArrayList<ProductBean>)hs.getAttribute("al"); 
String code = req.getParameter("pcode"); 
al.forEach((k)->{ 
if(code.equals(k.getCode())) { 
k.setPrice(Float.parseFloat(req.getParameter("pprice"))); 
k.setQty(Integer.parseInt(req.getParameter("pqty"))); 
int z = new UpdateProductDAO().update(k); 
if(z>0) { 
pw.println("Product Updated Successfully..<br>"); 
} 
} 
}); 
RequestDispatcher rd =  
req.getRequestDispatcher("link1.html"); 
rd.include(req, res); 
} 
} 
} 

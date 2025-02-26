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
@WebServlet("/edit") 
 
public class EditProductServlet extends HttpServlet{ 
@SuppressWarnings("unchecked") 
@Override
protected void doGet(HttpServletRequest req, 
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
String code = req.getParameter("pcode"); 
ArrayList<ProductBean> al =  
(ArrayList<ProductBean>)hs.getAttribute("al"); 
al.forEach((k)-> 
{ 
if(code.equals(k.getCode())) { 
pw.println("<form action='update' method='POST'>"); 
pw.println("<input type='hidden' name='pcode' value='"+code+"'><br>"); 
pw.println("ProdPrice:<input type='text' name='pprice' value='"+k.getPrice()+"'><br>"); 
pw.println("ProdQty:<input type='text' name='pqty' value='"+k.getQty()+"'><br>"); 
pw.println("<input type='submit' value='UpdateProduct'>"); 
pw.println("</form>"); 
} 
}); 
} 
} 
}
package com.test;

import java.io.*; 
import java.util.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
import jakarta.servlet.annotation.*; 
@SuppressWarnings("serial") 
@WebServlet("/edit") 
public class EditProductServlet extends HttpServlet 
{ 
@SuppressWarnings("unchecked") 
@Override 
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws 
ServletException,IOException 
{ 
HttpSession hs = req.getSession(false); 
if(hs==null) { 
req.setAttribute("msg","Session Expired...<br>"); 
req.getRequestDispatcher("Msg.jsp").forward(req, res); 
}else { 
ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("alist"); 
String pC = req.getParameter("pcode"); 
Iterator<ProductBean> it = al.iterator();
 
   while(it.hasNext()) 
   { 
   ProductBean pb = (ProductBean)it.next(); 
   if(pC.equals(pb.getCode())) { 
    req.setAttribute("pbean", pb); 
    req.getRequestDispatcher("EditProduct.jsp").forward(req, res); 
    break; 
   }//end of if 
   }//end of while 
   } 
  } 
} 

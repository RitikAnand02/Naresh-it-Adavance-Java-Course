package com.test;

import java.io.*; 
import java.util.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
import jakarta.servlet.annotation.*; 
@SuppressWarnings("serial") 
@WebServlet("/update") 
public class UpdateProductServlet extends HttpServlet 
{ 
    @SuppressWarnings("unchecked") 
 @Override 
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws 
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
      while(it.hasNext()) { 
       ProductBean pb = (ProductBean)it.next(); 
       if(pC.equals(pb.getCode())) { 
 
        pb.setPrice(Float.parseFloat(req.getParameter("price"))); 
        pb.setQty(Integer.parseInt(req.getParameter("qty"))); 
        int k = new UpdateProductDAO().update(pb); 
        if(k>0) { 
         req.setAttribute("msg","Product Updated Successfully...<br>"); 
         req.getRequestDispatcher("UpdateProduct.jsp").forward(req, 
res); 
        }//end of  
        break; 
       }//end of if 
      }//end of loop 
     } 
    } 
} 

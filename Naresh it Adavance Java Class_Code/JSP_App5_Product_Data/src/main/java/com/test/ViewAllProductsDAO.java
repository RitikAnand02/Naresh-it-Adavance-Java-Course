package com.test;

import java.util.*; 
 import java.sql.*; 
 
public class ViewAllProductsDAO  
{ 
   public ArrayList<ProductBean> al = new ArrayList<ProductBean>(); 
   public ArrayList<ProductBean> retrieve() 
   { 
    try { 
     Connection con = DBConnection.getCon(); 
     PreparedStatement ps = con.prepareStatement 
       ("select * from Product70"); 
     ResultSet rs = ps.executeQuery(); 
     while(rs.next()) { 
     ProductBean pb = new ProductBean(); 
     pb.setCode(rs.getString(1)); 
     pb.setName(rs.getString(2)); 
     pb.setPrice(rs.getFloat(3)); 
     pb.setQty(rs.getInt(4)); 
     al.add(pb);//Bean added to ArrayList 
     }//end of loop 
    }catch(Exception e) { 
     e.printStackTrace(); 
    } 
    return al; 
   } 
} 

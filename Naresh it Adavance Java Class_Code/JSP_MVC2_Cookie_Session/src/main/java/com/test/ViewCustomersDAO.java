package com.test;

import java.sql.*; 
import java.util.*; 
public class ViewCustomersDAO { 
   public ArrayList<CustomerBean> al = new ArrayList<CustomerBean>(); 
   public ArrayList<CustomerBean> retrieve(){ 
    try { 
     Connection con = DBConnection.getCon(); 
     PreparedStatement ps = con.prepareStatement 
       ("select * from Customer70"); 
     ResultSet rs = ps.executeQuery(); 
     while(rs.next()) { 
      CustomerBean cb = new CustomerBean(); 
      cb.setId(rs.getInt(1)); 
      cb.setName(rs.getString(2)); 
      cb.setCity(rs.getString(3)); 
      cb.setmId(rs.getString(4)); 
      cb.setPhNo(rs.getLong(5)); 
      al.add(cb); 
     }//end og loop 
    }catch(Exception e) { 
     e.printStackTrace(); 
    } 
    return al; 
   } 
}
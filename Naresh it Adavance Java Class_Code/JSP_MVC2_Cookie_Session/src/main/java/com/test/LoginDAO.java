package com.test;

import java.sql.*; 
public class LoginDAO  
{ 
    public String fName=null; 
    public String login(String uN,String pW) 
    { 
     try { 
      Connection con = DBConnection.getCon(); 
      PreparedStatement ps = con.prepareStatement 
        ("select * from Admin70 where uname=? and pword=?"); 
      ps.setString(1, uN); 
      ps.setString(2, pW); 
      ResultSet rs = ps.executeQuery(); 
      if(rs.next()) { 
       fName = rs.getString(3); 
      } 
     }catch(Exception e) { 
      e.printStackTrace(); 
     } 
     return fName; 
    } 
} 
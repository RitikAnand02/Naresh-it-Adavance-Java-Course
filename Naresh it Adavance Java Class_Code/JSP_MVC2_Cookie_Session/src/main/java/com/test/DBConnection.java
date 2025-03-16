package com.test;

import java.sql.*; 
public class DBConnection  
{ 
     private static Connection con = null; 
     private DBConnection() {} 
     static 
     { 
      try { 
       Class.forName(DBInfo.driver); 
       con = DriverManager.getConnection 
         (DBInfo.dbURL,DBInfo.dbUName,DBInfo.dbPWord); 
      }catch(Exception e) { 
       e.printStackTrace(); 
 
      } 
     }//end of block 
     public static Connection getCon() 
     { 
      return con; 
     } 
}
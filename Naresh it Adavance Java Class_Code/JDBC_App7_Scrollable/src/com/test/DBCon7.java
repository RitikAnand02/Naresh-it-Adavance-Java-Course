package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBCon7 {
	public static void main(String[] args) {
        try {
        	 Connection con = DriverManager.getConnection
        	("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
        			           //Creating Connection
        	 Statement stm = con.createStatement
        			 (ResultSet.TYPE_SCROLL_INSENSITIVE,
        					 ResultSet.CONCUR_READ_ONLY);
        	 ResultSet rs = stm.executeQuery
        			 ("select * from Product52");
        	 System.out.println("****Table data*****");
        	 while(rs.next()) {
        		 System.out.println(rs.getInt(1)+"\t"
        				 +rs.getString(2)+"\t"
        				 +rs.getInt(3)+"\t"
        				 +rs.getInt(4));
        	 }
        	 System.out.println("****Table data in reverse*****");
        	 rs.afterLast();//Cursor pointing after last row
        	 while(rs.previous()) {
        		 System.out.println(rs.getInt(1)+"\t"
        				 +rs.getString(2)+"\t"
        				 +rs.getInt(3)+"\t"
        				 +rs.getInt(4));
        	 }//end of loop
        	 PreparedStatement ps = con.prepareStatement
        			 ("select * from Product52",1004,1007);
        	 ResultSet rs2 = ps.executeQuery();
        	 System.out.println("****Last_Row****");
        	 rs2.last();
        	 System.out.println(rs2.getInt(1)+"\t"
    				 +rs2.getString(2)+"\t"
    				 +rs2.getInt(3)+"\t"
    				 +rs2.getInt(4));
        	 System.out.println("****Frist_Row****");
        	 rs2.first();
        	 System.out.println(rs2.getInt(1)+"\t"
    				 +rs2.getString(2)+"\t"
    				 +rs2.getInt(3)+"\t"
    				 +rs2.getInt(4));
        	 System.out.println("****Absolute(2)****");
        	 rs2.absolute(2);
        	 System.out.println(rs2.getInt(1)+"\t"
    				 +rs2.getString(2)+"\t"
    				 +rs2.getInt(3)+"\t"
    				 +rs2.getInt(4));
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
}


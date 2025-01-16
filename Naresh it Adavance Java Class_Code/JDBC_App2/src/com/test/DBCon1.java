// Retrieve Data from the table:Emp52

package com.test;
import java.sql.*;

public class DBCon1 {
   public static void main(String[] args) {
	   try 
	   {
	   Class.forName("oracle.jdbc.driver.OracleDriver"); //Loading Driver
	   
	   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1234");
	   // Creating Connection
	   
	   Statement stm = con.createStatement(); // Preparing statement
	   
	   ResultSet rs = stm.executeQuery("select * from Product52"); // Executing Query
	   
	   while(rs.next()) {
		   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)); 
	   }
	   
	   con.close(); // Closing Connection
	   }
	   catch(Exception e) 
	   {
		   e.printStackTrace();
	   }
	   
	 
   }
}


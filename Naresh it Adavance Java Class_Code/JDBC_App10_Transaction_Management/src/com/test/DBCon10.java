package com.test;

import java.sql.*;
import java.util.*;
public class DBCon10 {
	public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      try(s;){
    	  try {
    		  Connection con = DriverManager.getConnection
    ("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
    		  System.out.println("Status of AutoCommit : "+con.getAutoCommit());
    		  con.setAutoCommit(false);
    		  System.out.println("Status of AutoCommit : "+con.getAutoCommit());
      		  PreparedStatement ps1 = con.prepareStatement
      				  ("select * from Bank52 where accNo=?");
      		  PreparedStatement ps2 = con.prepareStatement
      				  ("update Bank52 set bal=bal+? where accNo=?");
      		  Savepoint sp = con.setSavepoint();
      		  System.out.println("Enter the Home AccNo:");
      		  long hAccNo = s.nextLong();
      		  ps1.setLong(1, hAccNo);
      		  ResultSet rs1 = ps1.executeQuery();
      		  if(rs1.next()) {
      			 float bl = rs1.getFloat(3); 
      			 System.out.println("Enter beneficiery AccNo:");
      			 long bAccNo = s.nextLong();
      			 ps1.setLong(1, bAccNo);
      			 ResultSet rs2 = ps1.executeQuery();
      			 if(rs2.next()) {
                    System.out.println("Enter the amt to be Transferred:");
                    float amt = s.nextFloat();
                    if(amt<=bl) {
                    	ps2.setFloat(1,-amt);
                    	ps2.setLong(2, hAccNo);
                    	int i = ps2.executeUpdate();//Updated in buffer
                    	
                    	ps2.setFloat(1, amt);
                    	ps2.setLong(2, bAccNo);
                    	int j = ps2.executeUpdate();//Updated in buffer
                    	
                    	if(i==1 && j==1) {
                    		System.out.println("Transaction Successfull...");
                    		con.commit();//Update the database
                    	}else {
                    		System.out.println("Transaction Failed...");
                    		con.rollback(sp);
                    	}
                    }else {
                    	System.out.println("Insufficient fund...");
                    }
      			 }else {
      				 System.out.println("Invalid bAccNo...");
      			 }
      		  }else {
      			  System.out.println("Invalid homeAccNo...");
      		  }
    	  }catch(Exception e) {e.printStackTrace();}
      }//end of try with resource
	}
}

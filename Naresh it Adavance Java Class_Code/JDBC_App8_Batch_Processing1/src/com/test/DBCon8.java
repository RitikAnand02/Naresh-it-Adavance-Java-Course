package com.test;

import java.util.*;
import java.sql.*;
public class DBCon8 {
	public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       try(s){
    	   try {
    		   Connection con = DriverManager.getConnection
   ("jdbc:oracle:thin:@localhost:1521:orcl","system","1234"); 
    		   Statement stm = con.createStatement();
    		   
    		   System.out.println("****Enter BookDetails****");
    		   System.out.println("Enter the code:");
    		   String code = s.nextLine();
    		   System.out.println("Enter the name:");
    		   String name = s.nextLine();
    		   System.out.println("Enter the author:");
    		   String author = s.nextLine();
    		   System.out.println("Enter the price:");
    		   float price = Float.parseFloat(s.nextLine());
    		   System.out.println("Enter the qty:");
    		   int qty = Integer.parseInt(s.nextLine());
    		   
    		   System.out.println("====Delete employee====");
    		   System.out.println("Enter the empId:");
    		   String id = s.nextLine();
    		   
    		   stm.addBatch
    		   ("insert into BookDetails52 values('"+code+"','"+name+"','"+author+"',"+price+","+qty+")");
    		   stm.addBatch("delete from Emp52 where id='"+id+"'");
    		   
    		   int k[] = stm.executeBatch();
    		   for(int i=0;i<k.length;i++) {
    			   System.out.println("Executed Successfully...");
    		   }
    		   stm.clearBatch();
    		   con.close();
    	   }catch(Exception e) {e.printStackTrace();}
       }//end of try
	}
}

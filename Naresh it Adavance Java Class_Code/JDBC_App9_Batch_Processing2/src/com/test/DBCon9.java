package com.test;

import java.util.*;
import java.sql.*;
public class DBCon9 {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try(s;){
        	try {
        		Connection con = DriverManager.getConnection
        	("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
        			           //Creating Connection 
        		PreparedStatement ps = con.prepareStatement ("insert into Product52 values(?,?,?,?)");
        		System.out.println("Enter the number of Products:");
        		int n = Integer.parseInt(s.nextLine());
        		System.out.println("Enter "+n+" Product details...");
        		for(int i=1;i<=n;i++) {
        			System.out.println("****Details of Product-"+i+"****");
        			System.out.println("Enter the ProdCode:");
        			String code = s.nextLine();
        			System.out.println("Enter the ProdName:");
        			String name = s.nextLine();
        			System.out.println("Enter the ProdPrice:");
        			float price = Float.parseFloat(s.nextLine());
        			System.out.println("Enter the ProdQty::");
        			int qty = Integer.parseInt(s.nextLine());
        			
        			ps.setString(1, code);
        			ps.setString(2, name);
        			ps.setFloat(3, price);
        			ps.setInt(4, qty);
        			
        			ps.addBatch();//Query will values added to batch
        		}//end of loop
        		int k[] = ps.executeBatch();
        		for(int i=0;i<k.length;i++) {
        			System.out.println("Executed Successfully...");
        		}
        		ps.clearBatch();
        		con.close();
        	}catch(Exception e) {e.printStackTrace();}
        }//end of try with resource
	}
}

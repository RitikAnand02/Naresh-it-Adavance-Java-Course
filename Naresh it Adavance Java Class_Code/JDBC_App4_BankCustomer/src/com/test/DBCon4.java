package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBCon4 {
      public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1234");
			   // Creating Connection
			  
			  PreparedStatement ps1 = con.prepareStatement("insert into BankCustomer52 values(?,?,?,?)"); //Compilation
			  PreparedStatement ps2 = con.prepareStatement("select * from BankCustomer52"); //Compilation
			
			  while(true) {
				  System.out.println("****Choice****");
				  System.out.println("\t1.AddBankCustomer"+ "\n\t2.ViewAllBankCustomer" + "\n\t3.Exit");
			     
				  System.out.println("Enter the Choice: ");
				  int choice = Integer.parseInt(sc.nextLine());
				  
				  switch(choice) {
				  case 1: 
					  System.out.println("Enter the AccNo: ");
					  int aN = Integer.parseInt(sc.nextLine());
					  
					  System.out.println("Enter the CustName: ");
					  String cN = sc.nextLine();
		
					  System.out.println("Enter the Balance: ");
					  Float bA = Float.parseFloat(sc.nextLine());
					  
					  System.out.println("Enter the AccType: ");
					  String aT = sc.nextLine();
					  
					  
					  // Setting data to ps1- Object
					  ps1.setInt(1, aN);
					  ps1.setString(2, cN);
					  ps1.setFloat(3, bA);
					  ps1.setString(4, aT);
					 
					  
					  int k = ps1.executeUpdate(); //Execution 
					  if(k>0) {
						  System.out.println("BankCustomer inserted Successfully...");
					  }
					  
					  break;
					  
				  case 2:
					  ResultSet rs = ps2.executeQuery(); //Execution
					  System.out.println("****Bank_Customer-Details****");
					  while(rs.next()) {
						  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
					  }
					  break;
					  
				  case 3:
					  System.out.println("Operation on DB Stopped...");
					  System.exit(0);
					  
				  default:
					  System.out.println("Invalid Choice...");
					  
				  }
			  }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

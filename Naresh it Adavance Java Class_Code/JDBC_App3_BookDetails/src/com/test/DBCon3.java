package com.test;
import java.util.*;
import java.sql.*;

public class DBCon3 {
      public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1234");
			   // Creating Connection
			  
			  PreparedStatement ps1 = con.prepareStatement("insert into BookDetails52 values(?,?,?,?,?)"); //Compilation
			  PreparedStatement ps2 = con.prepareStatement("select * from BookDetails52"); //Compilation
			  PreparedStatement ps3 = con.prepareStatement("select * from BookDetails52 where bcode=?");
			  PreparedStatement ps4 = con.prepareStatement("update BookDetails52 set bprice=?, bqty=bqty+? where bcode=?");
			  PreparedStatement ps5 = con.prepareStatement("delete from BookDetails52 where bcode=?");
			  
			  while(true) {
				  System.out.println("****Choice****");
				  System.out.println("\t1.AddBookDetails"+ "\n\t2.ViewAllBookDetails" +"\n\t3.ViewBookByCode"+"\n\t4.UpdateBookByBookCode(Price/Qty)"+"\n\t5.DeleteBookByBookCode" +"\n\t6.Exit");
			     
				  System.out.println("Enter the Choice: ");
				  int choice = Integer.parseInt(sc.nextLine());
				  
				  switch(choice) {
				  case 1: 
					  System.out.println("Enter the BookCode: ");
					  String bC = sc.nextLine();
					  
					  System.out.println("Enter the BookName: ");
					  String bN = sc.nextLine();
					  
					  System.out.println("Enter the BookAuthor: ");
					  String bA = sc.nextLine();
					  
					  System.out.println("Enter the BookPrice: ");
					  Float bP = Float.parseFloat(sc.nextLine());
					  
					  System.out.println("Enter the BookQty: ");
					  int bQ = Integer.parseInt(sc.nextLine());
					  
					  // Setting data to ps1- Object
					  ps1.setString(1, bC);
					  ps1.setString(2, bN);
					  ps1.setString(3, bA);
					  ps1.setFloat(4, bP);
					  ps1.setInt(5, bQ);
					  
					  int k = ps1.executeUpdate(); //Execution 
					  if(k>0) {
						  System.out.println("BookDeatils inserted Successfully...");
					  }
					  else {
						  System.err.println("Invalid BookDetails...");

					  }
					  
					  break;
					  
				  case 2:
					  ResultSet rs = ps2.executeQuery(); //Execution
					  System.out.println("****Book-Details****");
					  while(rs.next()) {
						  System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
					  }
					  break;
					  
				  case 3:
					  System.out.println("Enter the BookCode: ");
					  String code = sc.nextLine();
					  
					  //setting data to ps3-object
					  ps3.setString(1, code);
					  
					  ResultSet rs2 = ps3.executeQuery();
					  if(rs2.next()) {
						  System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));

					  }
					  else {
						  System.err.println("Invalid Book Code...");
					  }
					  
					  break;
					  
				  case 4:
					  System.out.println("Enter the BookCode: ");
					  String code2 = sc.nextLine();
					  ps3.setString(1, code2);
					  
					  ResultSet rs3 = ps3.executeQuery();
					  
					  if(rs3.next()) {
						  System.out.println("Old Book Price: "+rs3.getString(4));
						  System.out.println("Enter New BookPrice: ");
						  float nPrice = Float.parseFloat(sc.nextLine());
						  
						  System.out.println("Old Book Qty: "+rs3.getString(5));
						  System.out.println("Enter New :BookQty: ");
						  int nQty = Integer.parseInt(sc.nextLine());
						  
						  ps4.setFloat(1, nPrice);
						  ps4.setInt(2, nQty);
						  ps4.setString(3, code2);
						  
						  int k2 = ps4.executeUpdate();
						  
						  if(k2>0)
						  {
							 System.out.println("Book Price and Qty Updated...");
						  }
						  else {
							  System.err.println("Invalid BookCode...");
						  }
					  }
					  break;
					  
				  case 5:
					  System.out.println("Enter the BookCode: ");
					  String code3 = sc.nextLine();
					  ps3.setString(1, code3);
					  ResultSet rs4 = ps3.executeQuery();
					  if(rs4.next()) {
						  ps5.setString(1, code3);
						  int k3 = ps5.executeUpdate();
						  if(k3>0) {
							  System.out.println("BookDeatils deleted successfully...");
						  }
					  }
					  else {
						  System.err.println("Invalid BookCode...");
					  }
					  break;
					  
				  case 6:
					  System.out.println("Operation on DB Stopped...");
					  System.exit(0);
					  
				  default:
					  System.out.println("Invalid Choice...");
					  
					  con.close();
					  
				  }
			  }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

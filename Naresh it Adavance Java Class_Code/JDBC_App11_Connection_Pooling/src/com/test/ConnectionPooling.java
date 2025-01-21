package com.test;

import java.util.*;
import java.sql.*;
public class ConnectionPooling {
  public String dbUrl,uName,pWord;
  public ConnectionPooling(String dbUrl,String uName,
		  String pWord) {
	  this.dbUrl=dbUrl;
	  this.uName=uName;
	  this.pWord=pWord;
  }
  public Vector<Connection> v = new Vector<Connection>();
  public void createConnections() {
	  try {
		  while(v.size()<5) {
			  System.out.println("Pool is not full....");
			  Connection con = DriverManager.getConnection
                      (dbUrl,uName,pWord);
			  v.add(con);
			  System.out.println(con);
		  }//end of loop
		  if(v.size()==5) {
			  System.out.println("Pool is full....");
		  }
	  }catch(Exception e) {e.printStackTrace();}
  }//end of method
  
}


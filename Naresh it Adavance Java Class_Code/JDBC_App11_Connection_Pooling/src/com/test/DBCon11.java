package com.test;

public class DBCon11 {
	public static void main(String[] args) {
       ConnectionPooling cp = new ConnectionPooling
    		   ("jdbc:oracle:thin:@localhost:1521:orcl",
    				   "system","1234");
       cp.createConnections();
	}
}


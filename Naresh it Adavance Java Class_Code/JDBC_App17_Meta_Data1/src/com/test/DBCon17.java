package com.test;

import java.sql.*;
public class DBCon17 {
public static void main(String[] args) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
System.out.println("*******DatabaseMetaData******");
DatabaseMetaData dmd = con.getMetaData();
System.out.println("DB Name :"+dmd.getDatabaseProductName());
System.out.println("DB Version :"+dmd.getDatabaseProductVersion());
System.out.println("DB driver : "+dmd.getDriverName());
}catch(Exception e) {
e.printStackTrace();
}
}
}

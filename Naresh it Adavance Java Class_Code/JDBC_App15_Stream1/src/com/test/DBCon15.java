package com.test;

import java.io.*;
import java.util.*;
import java.sql.*;
public class DBCon15 {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
try(s;){
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
PreparedStatement ps = con.prepareStatement
("insert into StreamTab70 values(?,?)");
System.out.println("Enter the Id to Store Image:");
String id = s.nextLine();
System.out.println("Enter the fPath&fName(source of Image)");
String path = s.nextLine();
File f = new File(path);
if(f.exists()) {
FileInputStream fis = new FileInputStream(path);
ps.setString(1, id);
ps.setBinaryStream(2, fis, f.length());
int k = ps.executeUpdate();
if(k>0) {
System.out.println("Image Stored Successfully...");
}
}else {
System.out.println("Invalid fPath or fName....");
}
}catch(Exception e) {
e.printStackTrace();
}
}
}


package com.test;

import java.util.*;
import java.io.*;
import java.sql.*;
public class DBCon16 {
public static void main(String[] args) {

Scanner s = new Scanner(System.in);
try(s;){
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
PreparedStatement ps = con.prepareStatement
("select * from StreamTab70 where id=?");
System.out.println("Enter the id to retrieve Image:");
String id = s.nextLine();
ps.setString(1, id);
ResultSet rs = ps.executeQuery();
if(rs.next()) {
Blob b = rs.getBlob(2);
byte by[] = b.getBytes(1, (int)b.length());
System.out.println("Enter the fPath&fName(destination to store image)");
String path = s.nextLine();
FileOutputStream fos = new FileOutputStream(path);
fos.write(by);
System.out.println("Image retrieved Successfully...");
fos.close();
}else {
System.out.println("Invalid id....");
}
}catch(Exception e) {
e.printStackTrace();
}
}
}

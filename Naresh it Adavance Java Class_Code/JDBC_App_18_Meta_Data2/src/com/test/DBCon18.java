package com.test;

import java.sql.*;
public class DBCon18
{
public static void main(String[] args)
{
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
PreparedStatement ps1 = con.prepareStatement
("insert into Product70 values(?,?,?,?)");
System.out.println("********ParameterMetaData*******");
ParameterMetaData pmd = ps1.getParameterMetaData();
System.out.println("Para count :"+pmd.getParameterCount());
PreparedStatement ps2 = con.prepareStatement
("select id,mailid,phno from Customer70");
ResultSet rs = ps2.executeQuery();
System.out.println("------deatails-----");
while(rs.next()) {
System.out.println(rs.getInt(1)+"\t"
+rs.getString(2)+"\t"
+rs.getLong(3));
}//end of loop
System.out.println("*****ResultSetMetaData******");
ResultSetMetaData rsmd = rs.getMetaData();
System.out.println("Col Count : "+rsmd.getColumnCount());
System.out.println("2nd Col Name :"+rsmd.getColumnName(2));
}catch(Exception e) {
e.printStackTrace();
}
}
}
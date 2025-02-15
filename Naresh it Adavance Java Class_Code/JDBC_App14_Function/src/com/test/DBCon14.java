package com.test;

import java.util.*;
import java.sql.*;
public class DBCon14 
{
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
try(s;){
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
CallableStatement cs = con.prepareCall
("{call ?:=RetrieveBalance70(?)}");
System.out.println("Enter the AccNo to retrieve Balance:");
long accNo = s.nextLong();
cs.setLong(2, accNo);
cs.registerOutParameter(1, Types.FLOAT);
cs.execute();
System.out.println("Cust-Balance:"+cs.getFloat(1));
con.close();
}catch(Exception e) {
e.printStackTrace();
}
}
}

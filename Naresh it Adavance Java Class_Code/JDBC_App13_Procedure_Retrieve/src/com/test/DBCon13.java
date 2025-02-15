package com.test;

import java.util.*;
import java.sql.*;
public class DBCon13 {
public static void main(String[] args)
{
Scanner s = new Scanner(System.in);

try(s;){
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
CallableStatement cs = con.prepareCall
("{call RetrieveDetails70(?,?,?,?,?,?,?,?,?)}");
System.out.println("Enter the Cust-AccNo to retrieve details:");
long accNo = Long.parseLong(s.nextLine());
cs.setLong(1, accNo);
cs.registerOutParameter(2, Types.VARCHAR);
cs.registerOutParameter(3, Types.FLOAT);
cs.registerOutParameter(4, Types.VARCHAR);
cs.registerOutParameter(5, Types.VARCHAR);
cs.registerOutParameter(6, Types.VARCHAR);
cs.registerOutParameter(7, Types.INTEGER);
cs.registerOutParameter(8, Types.VARCHAR);
cs.registerOutParameter(9, Types.BIGINT);
cs.execute();
System.out.println("--------Customer Details-------");
System.out.println("Cust-Name : "+cs.getString(2));
System.out.println("Cust-Bal : "+cs.getFloat(3));
System.out.println("Cust-AccType : "+cs.getString(4));
System.out.println("Cust-City : "+cs.getString(5));
System.out.println("Cust-State : "+cs.getString(6));
System.out.println("Cust-PinCode : "+cs.getInt(7));

System.out.println("Cust-MailId : "+cs.getString(8));
System.out.println("Cust-PhoneNo : "+cs.getLong(9));
con.close();
}catch(Exception e) {
e.printStackTrace();
}
}
}

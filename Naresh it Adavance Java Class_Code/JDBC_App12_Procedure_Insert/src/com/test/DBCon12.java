package com.test;

import java.util.*;
import java.sql.*;
public class DBCon12 {
public static void main(String[] args)
{
Scanner s = new Scanner(System.in);
try(s;){
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
CallableStatement cs = con.prepareCall
("{call CreateAccount70(?,?,?,?,?,?,?,?,?)}");
System.out.println("Enter the AccNo:");
long accNo = Long.parseLong(s.nextLine());
System.out.println("Enter the Cust-Name:");
String name = s.nextLine();
System.out.println("Enter the Cust-Bal:");
float bal = Float.parseFloat(s.nextLine());
System.out.println("Enter the Cust-AccType:");
String accType = s.nextLine();
System.out.println("Enter the Cust-City:");
String city = s.nextLine();
System.out.println("Enter the Cust-State:");
String state = s.nextLine();
System.out.println("Enter the Cust-PinCode:");
int pinCode = Integer.parseInt(s.nextLine());
System.out.println("Enter the Cust-MailId:");
String mId = s.nextLine();
System.out.println("Enter the Cust-PhoneNo:");
long phNo = Long.parseLong(s.nextLine());
//Loading data to CallableStatement Object
cs.setLong(1, accNo);
cs.setString(2, name);
cs.setFloat(3, bal);
cs.setString(4, accType);
cs.setString(5, city);
cs.setString(6, state);
cs.setInt(7, pinCode);
cs.setString(8, mId);
cs.setLong(9, phNo);
cs.execute();//Procedure Executed...
System.out.println("Customer Account created Successfully....");
}catch(Exception e) {
e.printStackTrace();
}
}
}


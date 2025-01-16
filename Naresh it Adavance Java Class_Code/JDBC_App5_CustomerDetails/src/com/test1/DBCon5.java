package com.test1;

import java.sql.*;
import java.util.Scanner;
public class DBCon5
{
public static void main(String[] args)
{
Scanner s = new Scanner(System.in);
try(s;){
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
Statement stm = con.createStatement();
while(true) {
System.out.println("******Operations Choice*****");
System.out.println("\t1.AddCustomer"
+ "\n\t2.ViewAllCustomers"
+ "\n\t3.ViewCustomerById"
+ "\n\t4.Exit");
System.out.println("Enter your choice:");
int choice = Integer.parseInt(s.nextLine());
switch(choice)
{
case 1:
System.out.println("--------CutomerDetails---------");
System.out.println("Enter the Cust-Id:");
int id = Integer.parseInt(s.nextLine());
System.out.println("Enter the Cust-Name:");
String name = s.nextLine();
System.out.println("Enter the Cust-City:");
String city = s.nextLine();
System.out.println("Enter the Cust-MailId:");
String mId = s.nextLine();
System.out.println("Enter the Cust-PhNo:");
long phNo = Long.parseLong(s.nextLine());
int k = stm.executeUpdate("insert into Customer70 values("+id+",'"+name+"','"+city+"','"+mId+"',"+phNo+")");
if(k>0) {
System.out.println("Custome Added Successfully...");
}
break;
case 2:
ResultSet rs1 = stm.executeQuery("select * from Customer70");
System.out.println("------Customer Details-----");
while(rs1.next()) {
System.out.println(rs1.getInt(1)+"\t"
+rs1.getString(2)+"\t"
+rs1.getString(3)+"\t"
+rs1.getString(4)+"\t"
+rs1.getLong(5));
}//end of loop
break;
case 3:
System.out.println("Enter the Cust-Id to display the details...");
int cId = Integer.parseInt(s.nextLine());
ResultSet rs2 = stm.executeQuery("select * from Customer70 where id="+cId+"");
if(rs2.next()) {
System.out.println(rs2.getInt(1)+"\t"
+rs2.getString(2)+"\t"
+rs2.getString(3)+"\t"
+rs2.getString(4)+"\t"
+rs2.getLong(5));
}else {
System.out.println("Invalid Customer Id....");
}
break;
case 4:
System.out.println("Operations Stopped....");
System.exit(0);
default:
System.out.println("Invalid Choice...");
}//end of switch
}//end of loop
}catch(SQLIntegrityConstraintViolationException sq) {
System.out.println("Customer details already available...");
}catch(Exception e) {
e.printStackTrace();
}
}
}

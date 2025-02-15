package com.test;

import java.sql.*;
import java.util.*;;
public class DBCon19 {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
try(s;)//Java9
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
try(con;){
Statement stm = con.createStatement();
try(stm;){
System.out.println("Enter the query(Create/Insert/Update/Delete)");
String qry = s.nextLine();
int k = stm.executeUpdate(qry);
System.out.println("Value k : "+k);
if(k>=0) {
System.out.println("query executed successfully....");
}
}//end of try
}//end of try
}//end of try
catch(SQLSyntaxErrorException qs) {
System.out.println(qs.getMessage());
}
catch(SQLIntegrityConstraintViolationException se) {
System.out.println(se.getMessage());
System.out.println(se.getErrorCode());
}
catch(Exception e)
{
e.printStackTrace();
}
}//end of try with resource
}
}

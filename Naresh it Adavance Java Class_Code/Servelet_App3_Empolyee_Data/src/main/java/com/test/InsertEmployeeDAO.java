package com.test;

import java.sql.*;
public class InsertEmployeeDAO {
public int k=0;
public int insert(EmployeeBean eb) {
try {
Connection con = DBConnection.getCon();
PreparedStatement ps = con.prepareStatement("insert into Employee52 values(?,?,?,?,?)");
ps.setString(1, eb.getId());
ps.setString(2, eb.getName());
ps.setString(3, eb.getDesg());
ps.setInt(4, eb.getbSal());
ps.setFloat(5, eb.getTotSal());
k = ps.executeUpdate();
}catch(Exception e) {e.printStackTrace();}
return k;
}
}

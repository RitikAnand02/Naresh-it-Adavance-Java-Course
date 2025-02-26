package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServletRequest;

public class AdminLoginDAO {
public AdminBean ab = null;
public AdminBean login(HttpServletRequest req) {
try {
Connection con = DBConnection.getCon();
PreparedStatement ps = con.prepareStatement
("select * from AdminTab52 where uname=? and pword=?");
ps.setString(1, req.getParameter("uname"));
ps.setString(2, req.getParameter("pword"));
ResultSet rs = ps.executeQuery();
if(rs.next()) {
ab = new AdminBean();
ab.setuName(rs.getString(1));
ab.setpWord(rs.getString(2));
ab.setfName(rs.getString(3));
ab.setlName(rs.getString(4));
ab.setAddr(rs.getString(5));
ab.setmId(rs.getString(6));
ab.setPhNo(rs.getLong(7));
}
}catch(Exception e) {e.printStackTrace();}
return ab;
}
}

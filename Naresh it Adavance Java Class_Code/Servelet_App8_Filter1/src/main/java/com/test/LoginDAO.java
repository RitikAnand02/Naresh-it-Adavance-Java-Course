package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletRequest;

public class LoginDAO {
public UserBean ub = null;
public UserBean login(ServletRequest req) {
try {
Connection con = DBConnection.getCon();
PreparedStatement ps = con.prepareStatement
("select * from UserReg52 where uname=? and pword=?");
ps.setString(1, req.getParameter("uname"));
ps.setString(2, req.getParameter("pword"));
ResultSet rs = ps.executeQuery();
if(rs.next()) {
ub = new UserBean();
ub.setuName(rs.getString(1));
ub.setpWord(rs.getString(2));
ub.setfName(rs.getString(3));
ub.setlName(rs.getString(4));
ub.setAddr(rs.getString(5));
ub.setmId(rs.getString(6));
ub.setPhNo(rs.getLong(7));
}
}catch(Exception e) {e.printStackTrace();}
return ub;
}
}
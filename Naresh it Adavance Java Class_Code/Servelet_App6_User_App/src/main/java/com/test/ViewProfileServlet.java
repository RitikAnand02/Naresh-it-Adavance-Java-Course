package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet{
protected void doGet(HttpServletRequest req,
HttpServletResponse res)throws ServletException,
IOException{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
Cookie c[] = req.getCookies();
//Internally perform DeSerialization
if(c==null) {
pw.println("Session expired..<br>");
RequestDispatcher rd =
req.getRequestDispatcher("login.html");
rd.include(req, res);
}else {
String fName = c[0].getValue();
pw.println("Page belongs to User : "+fName+"<br>");
ServletContext sct = this.getServletContext();
UserBean ub = (UserBean)sct.getAttribute("ub");
pw.println(ub.getfName()+"&nbsp&nbsp&nbsp"
+ub.getlName()+"&nbsp&nbsp&nbsp"
+ub.getAddr()+"&nbsp&nbsp&nbsp"
+ub.getmId()+"&nbsp&nbsp&nbsp"
+ub.getPhNo()+"&nbsp&nbsp&nbsp"
+"<a href='edit'>EditProfile</a>"
+"&nbsp&nbsp&nbsp"
+"<a href='logout'>Logout</a>");
}
}
}

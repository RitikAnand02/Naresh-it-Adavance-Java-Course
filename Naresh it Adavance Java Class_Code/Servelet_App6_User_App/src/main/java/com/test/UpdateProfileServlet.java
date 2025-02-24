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
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet{
protected void doPost(HttpServletRequest req,
HttpServletResponse res)throws ServletException,
IOException{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
Cookie c[] = req.getCookies();
if(c==null) {
pw.println("Session expired...<br>");
RequestDispatcher rd =
req.getRequestDispatcher("login.html");
rd.include(req, res);
}else {
String fName = c[0].getValue();
ServletContext sct = this.getServletContext();
UserBean ub = (UserBean)sct.getAttribute("ub");
ub.setAddr(req.getParameter("addr"));
ub.setmId(req.getParameter("mid"));
ub.setPhNo(Long.parseLong(req.getParameter("phno")));
int k = new UpdateProfileDAO().update(ub);
pw.println("page belongs to User : "+fName+"<br>");
if(k>0) {
pw.println("Profile Updated Successfully...<br>");
RequestDispatcher rd =
req.getRequestDispatcher("link.html");
rd.include(req, res);
}
}
}
}


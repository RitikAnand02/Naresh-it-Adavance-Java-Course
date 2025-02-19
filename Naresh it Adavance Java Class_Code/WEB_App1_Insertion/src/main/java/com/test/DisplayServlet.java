package com.test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/dis")
public class DisplayServlet implements Servlet
{
@Override
public void init(ServletConfig scf)throws ServletException
{
//NoCode
}
@Override
public void service(ServletRequest req,ServletResponse res)
throws ServletException,IOException
{
String uName = req.getParameter("uname");
String mId = req.getParameter("mid");
long phNo = Long.parseLong(req.getParameter("phno"));
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
pw.println("******User Details*****<br>");
pw.println("UserName:"+uName+"<br>");
pw.println("MailId:"+mId+"<br>");
pw.println("PhoneNo:"+phNo+"<br>");
}
@Override
public void destroy()
{
//NoCode
}
@Override
public ServletConfig getServletConfig()
{
return this.getServletConfig();
}
@Override
public String getServletInfo()
{
return "This Servlet will display User details";
}
}

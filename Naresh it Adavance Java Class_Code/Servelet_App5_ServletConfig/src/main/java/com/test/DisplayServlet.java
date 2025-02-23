package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@SuppressWarnings("serial")
public class DisplayServlet extends GenericServlet{
public void service(ServletRequest req,ServletResponse res)
throws ServletException,IOException{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
String uName = req.getParameter("uname");
pw.println("Welcome : "+uName);
pw.println("<br>*****ServletConfig****");
ServletConfig scf = this.getServletConfig();
pw.println("<br>ServletName:"+scf.getServletName());
Enumeration<String> e = scf.getInitParameterNames();
while(e.hasMoreElements())
{
String pr = e.nextElement();
pw.println("<br>"+pr+":"+scf.getInitParameter(pr));
}//end of loop
}
}

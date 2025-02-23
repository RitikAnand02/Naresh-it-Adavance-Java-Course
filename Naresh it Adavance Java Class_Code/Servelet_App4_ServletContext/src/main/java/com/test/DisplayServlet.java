package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/dis")
public class DisplayServlet extends GenericServlet{
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
String uName = req.getParameter("uname");
pw.println("Welcome : "+uName);
ServletContext sct = this.getServletContext();
pw.println("<br>****ServletContext****");
pw.println("<br>ServerInfo:"+sct.getServerInfo());
Enumeration<String> e = sct.getInitParameterNames();
while(e.hasMoreElements())
{
String str = e.nextElement();
pw.println("<br>"+str+":"+sct.getInitParameter(str));
}//end of loop
}
}


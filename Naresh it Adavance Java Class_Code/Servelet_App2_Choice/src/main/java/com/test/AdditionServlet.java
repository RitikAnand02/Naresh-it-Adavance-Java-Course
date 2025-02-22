package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/ad")
public class AdditionServlet extends GenericServlet
{
@Override
public void service(ServletRequest req,ServletResponse res)throws ServletException,
IOException
{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
try {
int v1 = Integer.parseInt(req.getParameter("v1"));
int v2 = Integer.parseInt(req.getParameter("v2"));
int v3 = v1+v2;
pw.println("Sum:"+v3+"<br>");
}catch(Exception e) {
pw.println("Enter Only Integer Values....<br>");
}
RequestDispatcher rd = req.getRequestDispatcher("input.html");
rd.include(req, res);
}
}

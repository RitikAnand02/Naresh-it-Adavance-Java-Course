package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewEmployeesServlet extends GenericServlet{
public void service(ServletRequest req,ServletResponse res)
throws ServletException,IOException{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
ArrayList<EmployeeBean> al =
new ViewEmployeesDAO().retrieve();
if(al.size()==0) {
pw.println("No employees available...");
RequestDispatcher rd = req.getRequestDispatcher("choice.html");
rd.include(req, res);
}else {
al.forEach((k)->
{
EmployeeBean eb = (EmployeeBean)k;
pw.println(eb.getId()+"&nbsp&nbsp"+
eb.getName()+"&nbsp&nbsp"+
eb.getDesg()+"&nbsp&nbsp"+
eb.getbSal()+"&nbsp&nbsp"+
eb.getTotSal()+"<a href='edit'>Edit</a><a href='delete'>Delete</a><br>");});
pw.println("<a href='choice.html'>Back</a>");
}//end of else
}
}

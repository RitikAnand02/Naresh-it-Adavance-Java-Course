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
@WebServlet("/add")
public class AddEmployeeServlet extends GenericServlet{
public void service(ServletRequest req,ServletResponse res)
throws ServletException,IOException{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
EmployeeBean eb = new EmployeeBean();
eb.setId(req.getParameter("id"));
eb.setName(req.getParameter("name"));
eb.setDesg(req.getParameter("desg"));
int bSal = Integer.parseInt(req.getParameter("bsal"));
eb.setbSal(bSal);
float totSal = bSal+(0.93F*bSal)+(0.63F*bSal);
eb.setTotSal(totSal);
int k = new InsertEmployeeDAO().insert(eb);
if(k>0) {
pw.println("Employee Added Successfully...<br>");
RequestDispatcher rd =req.getRequestDispatcher("choice.html");
rd.include(req, res);
}

}
}
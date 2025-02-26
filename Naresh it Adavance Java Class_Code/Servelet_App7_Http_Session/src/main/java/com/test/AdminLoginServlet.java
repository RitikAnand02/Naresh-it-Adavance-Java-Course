package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req,
HttpServletResponse res)throws ServletException,
IOException{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
AdminBean ab = new AdminLoginDAO().login(req);
if(ab==null) {
pw.println("Invalid Login process...<br>");
RequestDispatcher rd =
req.getRequestDispatcher("home.html");
rd.include(req, res);
}else {
HttpSession hs = req.getSession();//Session created
hs.setAttribute("ab", ab);
pw.println("Welcome Admin : "+ab.getfName()+"<br>");
RequestDispatcher rd =
req.getRequestDispatcher("link1.html");
rd.include(req, res);
}
}
}
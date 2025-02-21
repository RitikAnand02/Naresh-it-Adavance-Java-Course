package com.test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/choice")
public class ChoiceServlet extends GenericServlet
{
@Override
public void service(ServletRequest req,ServletResponse res)throws ServletException,
IOException
{
String sb = req.getParameter("sb");

if(sb.equals("Add")) {
RequestDispatcher rd = req.getRequestDispatcher("ad");
rd.forward(req, res);
}
else if(sb.equals("Avg")){
RequestDispatcher rd = req.getRequestDispatcher("av");
rd.forward(req, res);
}
else if(sb.equals("Sub")){
RequestDispatcher rd = req.getRequestDispatcher("su");
rd.forward(req, res);
}
else if(sb.equals("Mul")){
RequestDispatcher rd = req.getRequestDispatcher("ml");
rd.forward(req, res);
}
else{
RequestDispatcher rd = req.getRequestDispatcher("dv");
rd.forward(req, res);
}

}
}
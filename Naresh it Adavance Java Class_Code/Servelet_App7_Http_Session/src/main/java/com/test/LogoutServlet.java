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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req,
HttpServletResponse res)throws ServletException,
IOException{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
HttpSession hs = req.getSession(false);
if(hs==null) {
pw.println("Session expired...<br>");
}else {
hs.removeAttribute("ab");
hs.invalidate();//session destroyed
pw.println("logged out Successfully...<br>");
}
RequestDispatcher rd =
req.getRequestDispatcher("home.html");
rd.include(req, res);
}
}

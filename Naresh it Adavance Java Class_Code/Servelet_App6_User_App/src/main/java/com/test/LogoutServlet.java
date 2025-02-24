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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
protected void doGet(HttpServletRequest req,
HttpServletResponse res)throws ServletException,
IOException{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
Cookie c[] = req.getCookies();
if(c==null) {
pw.println("Session Expired...<br>");
}else {
ServletContext sct = this.getServletContext();
sct.removeAttribute("ub");
c[0].setMaxAge(0);
res.addCookie(c[0]);
pw.println("User logged out Successfully..<br>");
}//end of else
RequestDispatcher rd =
req.getRequestDispatcher("login.html");
rd.include(req, res);
}
}

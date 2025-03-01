package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DisplayFilter implements Filter{ 
public FilterConfig fcf = null; 
@Override 
public void init(FilterConfig fcf)throws ServletException{ 
this.fcf=fcf; 
} 
@Override 
public void doFilter(ServletRequest req,ServletResponse res, FilterChain chain)throws ServletException,
IOException{ 
PrintWriter pw = res.getWriter(); 
res.setContentType("text/html"); 
String uName = req.getParameter("uname"); 
pw.println("Welcome UserName:"+uName+"<br>"); 
pw.println("****FilterConfig****<br>"); 
pw.println("FilterName:"+fcf.getFilterName()+"<br>"); 
Enumeration<String> e = fcf.getInitParameterNames(); 
while(e.hasMoreElements()) { 
String el = e.nextElement(); 
pw.println("value of "+el+" is "+fcf.getInitParameter(el)+"<br>"); 
}//end of loop 
} 
}
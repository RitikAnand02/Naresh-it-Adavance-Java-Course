package com.test;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener 
public class RequestListener implements ServletRequestListener, 
ServletRequestAttributeListener{ 
@Override 
public void requestInitialized(ServletRequestEvent sre) { 
System.out.println("request initialized..."); 
} 
@Override 
public void requestDestroyed(ServletRequestEvent sre) { 
System.out.println("request destroyed..."); 
} 
public void attributeAdded 
(ServletRequestAttributeEvent srae) { 
	System.out.println("request added with attribute..."); 
} 
public void attributeRemoved 
(ServletRequestAttributeEvent srae) { 
System.out.println("Attribute removed from request..."); 
} 
} 

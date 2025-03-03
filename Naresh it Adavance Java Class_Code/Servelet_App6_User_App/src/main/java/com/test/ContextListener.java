package com.test;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener 
public class ContextListener implements ServletContextListener, 
ServletContextAttributeListener{ 
@Override 
public void contextInitialized(ServletContextEvent sce) { 
System.out.println("Context Initialized..");  
} 
@Override 
public void contextDestroyed(ServletContextEvent sce) { 
System.out.println("Context destroyed..."); 
} 
@Override 
public void attributeAdded 
(ServletContextAttributeEvent scae) { 
System.out.println("Attribute added to Context...");   
} 
@Override 
public void attributeRemoved 
(ServletContextAttributeEvent scae) { 
System.out.println("Attribute removed from Context.."); 
} 
} 

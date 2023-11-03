package com.servlet.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppInit implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        ServletContextListener.super.contextDestroyed(sce);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        ServletContextListener.super.contextInitialized(sce);
    }
    
}

package com.servlet.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.servlet.utils.EnumTypeConverter;

public class EnumConverterListern implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        EnumTypeConverter.registerEnumConverters();
    }
    
}

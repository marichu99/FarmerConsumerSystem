package com.servlet.event;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.servlet.utils.EnumTypeConverter;

@Startup()
@Singleton
public class EnumConverterListern{
    @PreDestroy
    public void destroySout() {
        // TODO Auto-generated method stub
         System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Application is undeployed or destroyed");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    @PostConstruct
    public void init() {
        // TODO Auto-generated method stub
        EnumTypeConverter.registerEnumConverters();
    }
    
}

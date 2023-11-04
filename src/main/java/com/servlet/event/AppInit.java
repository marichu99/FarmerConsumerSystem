package com.servlet.event;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;
import com.servlet.database.Database;

public class AppInit implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        ServletContextListener.super.contextDestroyed(sce);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        // initialize the database
        Database dbInstance = Database.getDbInstance();
        dbInstance.getUsers().add(new User("mabera", "mabera@gmail.com", "mabera"));
        dbInstance.getUsers().add(new User("barny", "barny@gmail.com", "barny"));
        dbInstance.getUsers().add(new User("amran", "amran@gmail.com", "amran"));
        dbInstance.getUsers().add(new User("njeri", "njeri@gmail.com", "njeri"));

        // now let us add some produce
        dbInstance.getProducts().add(new Product(1, "maize", "yellow", 300, 10));
        dbInstance.getProducts().add(new Product(2, "beans", "yellow", 200, 20));
        dbInstance.getProducts().add(new Product(3, "tomato", "sweet tomato", 5000, 10));
        dbInstance.getProducts().add(new Product(4, "cabbage", "pink", 5000, 15));        
    }
    
}

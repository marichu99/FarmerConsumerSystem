package com.servlet.event;

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
        dbInstance.getProducts().add(new Product("001", "maize", "yellow", 300, 25, "cereals"));
        dbInstance.getProducts().add(new Product("002", "beans", "yellow", 200, 20, "cereals"));
        dbInstance.getProducts().add(new Product("003", "tomato", "sweet tomato", 5000, 25, "fruits"));
        dbInstance.getProducts().add(new Product("004", "cabbage", "pink", 5000, 25, "vegetables"));
        
    }
    
}

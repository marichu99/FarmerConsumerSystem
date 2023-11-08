package com.servlet.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;
import com.servlet.database.Database;
import com.servlet.view.html.UserProfile;

@WebListener
public class AppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("*************** Initializing database *************");

        Database dbInstance = Database.getDbInstance();
        dbInstance.getUsers().add(new User("mabera@gmail.com", "mabera","mabera"));
        dbInstance.getUsers().add(new User("barny@gmail.com", "barny","barny"));
        dbInstance.getUsers().add(new User( "amran@gmail.com", "amran","amran"));
        dbInstance.getUsers().add(new User("njeri@gmail.com", "njeri","njeri"));

        // now let us add some produce
        dbInstance.getProducts().add(new Product(1, "maize", "yellow", 300, 10));
        dbInstance.getProducts().add(new Product(2, "beans", "yellow", 200, 20));
        dbInstance.getProducts().add(new Product(3, "tomato", "sweet tomato", 5000, 10));
        dbInstance.getProducts().add(new Product(4, "cabbage", "pink", 5000, 15)); 

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

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

}


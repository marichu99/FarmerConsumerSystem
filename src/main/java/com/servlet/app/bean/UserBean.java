package com.servlet.app.bean;

import com.servlet.app.model.entity.User;
import com.servlet.database.Database;

public class UserBean implements UserBeanI{
    Database database = Database.getDbInstance();
    public boolean registerUser(User user){
        database.getUsers().add(user);      
        return true;       
    }
    public boolean unregisterUser(User user){
        database.getUsers().remove(user);
        return true;
    }
}

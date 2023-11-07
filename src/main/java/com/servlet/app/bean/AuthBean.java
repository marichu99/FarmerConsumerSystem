package com.servlet.app.bean;

import java.io.Serializable;


import com.servlet.app.model.entity.User;
import com.servlet.database.Database;

public class AuthBean implements AuthBeanI,Serializable{

    Database database = Database.getDbInstance();
    public User authenticatUser (User loginUser){
        User userDetails =null;
        for (User user : database.getUsers()) {       

            if(loginUser.getEmail().equals(user.getEmail()) && loginUser.getPassword().equals(user.getPassword())){
                userDetails=loginUser;
                break;
            }
        }
        return userDetails;
    }
    
}

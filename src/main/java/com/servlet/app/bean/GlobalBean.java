package com.servlet.app.bean;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote
public class GlobalBean implements Serializable{
    private static String userEmail;

    public static String getUserEmail() {
        return userEmail;
    }

    public static void setUserEmail(String userEmail) {
        GlobalBean.userEmail = userEmail;
    }

        
}

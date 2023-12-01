package com.servlet.utils;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.servlet.view.enums.UserType;

@Stateless
@Remote
public class GlobalBean implements Serializable{
    private static String userEmail;
    private static UserType userType;

    public static String getUserEmail() {
        return userEmail;
    }
    public static void setUserEmail(String userEmail) {
        GlobalBean.userEmail = userEmail;
    }
    public static UserType getUserType() {
        return userType;
    }
    public static void setUserType(UserType userType) {
        GlobalBean.userType = userType;
    }

        
}

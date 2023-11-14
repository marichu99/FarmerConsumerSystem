package com.servlet.app.bean;

import java.io.Serializable;

public class LoginForm implements Serializable{
    private String usernamePLaceholder= "Enter your username";
    private String passwordPlaceholder ="Enter your password";
    
    public LoginForm() {
    }
    public String getUsernamePLaceholder() {
        return usernamePLaceholder;
    }
    public void setUsernamePLaceholder(String usernamePLaceholder) {
        this.usernamePLaceholder = usernamePLaceholder;
    }
    public String getPasswordPlaceholder() {
        return passwordPlaceholder;
    }
    public void setPasswordPlaceholder(String passwordPlaceholder) {
        this.passwordPlaceholder = passwordPlaceholder;
    }
        
}

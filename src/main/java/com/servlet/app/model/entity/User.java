package com.servlet.app.model.entity;

import com.servlet.view.enums.UserType;
import com.servlet.view.html.AuthFormsAnnot;
import com.servlet.view.html.HtmlTable;
import com.servlet.view.html.HtmlTableColHeader;


@HtmlTable(addUrl = "./profile?action=add")
public class User {
    @HtmlTableColHeader(header = "Customer Email")
    private String email;
    private String password;
    @HtmlTableColHeader(header = "Customer Name")
    private String username;
    @AuthFormsAnnot()
    private UserType userType;
    
    public User(String email, String password, String username, UserType userType) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.userType = userType;
    }
    

    public User(UserType userType) {
        this.userType = userType;
    }


    public User() {
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }  
     public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    
}

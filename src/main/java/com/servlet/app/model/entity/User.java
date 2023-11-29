package com.servlet.app.model.entity;

import java.io.Serializable;

import com.servlet.database.helper.DbTable;
import com.servlet.database.helper.DbTableColumn;
import com.servlet.database.helper.DbTableID;
import com.servlet.view.enums.UserCategory;
import com.servlet.view.enums.UserType;
import com.servlet.view.html.annotation.AuthFormsAnnot;
import com.servlet.view.html.annotation.FarmerEnumAnnot;
import com.servlet.view.html.annotation.FarmerHtmlFormField;
import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;


@HtmlTable(addUrl = "./sign",deleteUrl = "./user?action=delete&id=")
@DbTable(name = "user")
public class User implements Serializable{

    @HtmlTableColHeader(header = "User ID")
    @DbTableColumn(colName = "userId", colDescription = "INT(11)")
    @DbTableID
    private int userId;

    @DbTableColumn(colName = "email" ,colDescription = "VARCHAR(255)")
    @HtmlTableColHeader(header = "Customer Email")
    @FarmerHtmlFormField(labelName = "Email",formType = "email", placeHolder = "Enter your email")
    private String email;

    @DbTableColumn(colName = "password",colDescription = "VARCHAR(255)")
    @FarmerHtmlFormField(labelName = "Password",formType = "password", placeHolder = "Enter your password")
    private String password;

    @DbTableColumn(colName = "username", colDescription = "VARCHAR(255)")
    @HtmlTableColHeader(header = "Customer Name")
    @FarmerHtmlFormField(labelName = "Username",formType = "text", placeHolder = "Enter your username")
    private String username;

    @DbTableColumn(colName = "usertype",colDescription = "VARCHAR(255)")
    @AuthFormsAnnot()
    @FarmerHtmlFormField(labelName = "Select the UserType",formType = "")
    @FarmerEnumAnnot
    private UserType userType;

    @DbTableColumn(colName = "userCategory",colDescription = "VARCHAR(255)")
    @FarmerEnumAnnot
    private UserCategory userCategory;
    
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


    public UserCategory getUserCategory() {
        return userCategory;
    }


    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }



    public int getUserId() {
        return userId;
    }



    public void setUserId(int userId) {
        this.userId = userId;
    }

    
}

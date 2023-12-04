package com.servlet.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.servlet.view.enums.UserCategory;
import com.servlet.view.enums.UserType;
import com.servlet.view.html.annotation.AuthFormsAnnot;
import com.servlet.view.html.annotation.FarmerEnumAnnot;
import com.servlet.view.html.annotation.FarmerHtmlFormField;
import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;

@HtmlTable(addUrl = "./sign", deleteUrl = "./user?action=delete&id=")
@Entity
@Table(name = "user")
// @DbTable(name = "user")
public class User extends BaseEntity {

    @Column(name = "email", columnDefinition = "VARCHAR(255)")
    @HtmlTableColHeader(header = "Customer Email")
    @FarmerHtmlFormField(labelName = "Email", formType = "email", placeHolder = "Enter your email")
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    @FarmerHtmlFormField(labelName = "Password", formType = "password", placeHolder = "Enter your password")
    private String password;

    @Column(name = "username", columnDefinition = "VARCHAR(255)")
    @HtmlTableColHeader(header = "Customer Name")
    @FarmerHtmlFormField(labelName = "Username", formType = "text", placeHolder = "Enter your username")
    private String username;

    @Column(name = "usertype", columnDefinition = "VARCHAR(255)")
    @AuthFormsAnnot(userType = UserType.USER)
    @FarmerHtmlFormField(labelName = "Select the UserType", formType = "")
    @FarmerEnumAnnot
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "userCategory", columnDefinition = "VARCHAR(255)")
    @Enumerated(EnumType.STRING)
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

}

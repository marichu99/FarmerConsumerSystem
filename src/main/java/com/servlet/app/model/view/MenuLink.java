package com.servlet.app.model.view;

import java.io.Serializable;

import com.servlet.app.model.entity.User;
import com.servlet.view.enums.UserType;

public class MenuLink implements Serializable{
    private String url;
    private String label;
    private MenuLinkStatus menuLinkStatus;
    
    public MenuLink(String url, String label, MenuLinkStatus menuLinkStatus) {
        this.url = url;
        this.label = label;
        this.menuLinkStatus = menuLinkStatus;
    }
    public UserType getUserType(User user){
        return user.getUserType();
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public MenuLinkStatus getMenuLinkStatus() {
        return menuLinkStatus;
    }
    public void setMenuLinkStatus(MenuLinkStatus menuLinkStatus) {
        this.menuLinkStatus = menuLinkStatus;
    }
    
    
}

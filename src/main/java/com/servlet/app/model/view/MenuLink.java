package com.servlet.app.model.view;

import java.io.Serializable;

public class MenuLink implements Serializable{
    private String url;
    private String label;
    private MenuLinkStatus menuLinkStatus;
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

package com.servlet.view.enums;

public enum UserAction {
    LOGIN("user login"),
    LOGOUT("user logout"),
    SIGNUP("user signup"),
    ADD_TO_CART("item added to cart"),
    BUY("item bought"),
    SOLD("item sold"),
    ADD_ITEM("item added");

    private String value;

    private UserAction(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }


}

package com.servlet.app.bean;

import javax.ejb.Remote;

import com.servlet.app.model.entity.User;

@Remote
public interface UserBeanI extends GenericBeanI<User>{
    boolean registerUser(User user);
}

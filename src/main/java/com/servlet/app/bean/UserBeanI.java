package com.servlet.app.bean;

import com.servlet.app.model.entity.User;

public interface UserBeanI extends GenericBeanI<User>{
    boolean registerUser(User user);
}

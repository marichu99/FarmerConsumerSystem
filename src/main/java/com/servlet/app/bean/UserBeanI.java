package com.servlet.app.bean;

import com.servlet.app.model.entity.User;

public interface UserBeanI {
    boolean registerUser(User user);
    boolean unregisterUser(User user);
}

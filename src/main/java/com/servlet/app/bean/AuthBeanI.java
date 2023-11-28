package com.servlet.app.bean;

import java.io.Serializable;

import com.servlet.app.model.entity.User;


public interface AuthBeanI extends Serializable{  
    User authenticatUser(User loginUser);
}

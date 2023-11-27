package com.servlet.app.bean;

import java.io.Serializable;

import javax.ejb.Remote;

import com.servlet.app.model.entity.User;

@Remote
public interface AuthBeanI extends Serializable{  
    User authenticatUser(User loginUser);
}

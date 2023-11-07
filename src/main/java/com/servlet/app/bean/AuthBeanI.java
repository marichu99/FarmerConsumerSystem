package com.servlet.app.bean;

import com.servlet.app.model.entity.User;

public interface AuthBeanI {  
    User authenticatUser(User loginUser);
}

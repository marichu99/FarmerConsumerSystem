package com.servlet.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.User;

@Stateless
@Remote
public class UserBean<T> extends GenericBean<User> implements UserBeanI{

    @Override
    public boolean registerUser(User user) {
        // TODO Auto-generated method stub
        try{
            getGenericDao().addOrUpdate(user);
            return true;
        }catch(Exception e){
            return false;
        }        
    }

}
  

package com.servlet.app.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.servlet.app.model.entity.User;
import com.servlet.utils.HashText;

@Stateless
@Local
public class UserBean<T> extends GenericBean<User> implements UserBeanI{
    @Inject
    HashText hashText;

    @Override
    public boolean registerUser(User user) {
        // check if the user already exists
        // use fetch instead of list on the method below
                // if(!getGenericDao().list(user).isEmpty()){
                //     // throw new RuntimeException("User Already Exists");

                // }
        // hash the input password
        try{
            hashText.hash(user.getPassword());
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        // TODO Auto-generated method stub
        try{
            getGenericDao().addOrUpdate(user);
            return true;
        }catch(Exception e){
            return false;
        }        
    }

}
  

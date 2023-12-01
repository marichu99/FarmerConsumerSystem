package com.servlet.app.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.servlet.app.model.entity.User;
import com.servlet.utils.EncryptText;
import com.servlet.utils.PasswordEnum;
import com.servlet.utils.PasswordTypeSelector;

@Stateless
@Local
public class UserBean<T> extends GenericBean<User> implements UserBeanI{
    @Inject
    @PasswordTypeSelector(passwordEnum = PasswordEnum.SHA256)
    EncryptText encryptText;

    @Override
    public boolean registerUser(User user) {
        // check if the user already exists
        // use fetch instead of list on the method below
                // if(!getGenericDao().list(user).isEmpty()){
                //     // throw new RuntimeException("User Already Exists");

                // }
        // hash the input password
        try{
            user.setPassword(encryptText.hash(user.getPassword()));
            System.out.println("###### the hash is "+user.getPassword());
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
  

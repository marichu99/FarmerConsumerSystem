package com.servlet.app.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.servlet.app.model.entity.User;
import com.servlet.database.MysqlDataBase;
import com.servlet.utils.EncryptText;
import com.servlet.utils.PasswordEnum;
import com.servlet.utils.PasswordTypeSelector;

@Stateless
@Remote
public class AuthBean implements AuthBeanI,Serializable{
    @EJB
    MysqlDataBase database;

    @Inject
    @PasswordTypeSelector(passwordEnum = PasswordEnum.SHA256)
    private EncryptText encryptText;
    public User authenticatUser(User loginUser) {

        try{
            System.out.println("The user type is ......"+loginUser.getUserType());
            if(loginUser.getUserType().toString().equals("USER"))
                loginUser.setPassword(encryptText.hash(loginUser.getPassword()));
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        try {
            List<User> users = database.fetch(loginUser);
            for(User user : users){
                if(loginUser.getUserId() == user.getUserId())
                    return user;
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

package com.servlet.app.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.servlet.app.model.entity.User;
import com.servlet.utils.EncryptText;
import com.servlet.utils.PasswordEnum;
import com.servlet.utils.PasswordTypeSelector;

@Stateless
@Remote
public class AuthBean implements AuthBeanI,Serializable{

    @PersistenceContext 
    EntityManager em;

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
            String fetchUser ="FROM user u where u.password=:password and u.email=:email";
            List<User> users = em.createQuery(fetchUser,User.class)
                .setParameter("password", loginUser.getPassword())
                .setParameter("email", loginUser.getEmail()).getResultList();
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

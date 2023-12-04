package com.servlet.app.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.servlet.app.model.entity.AuditLog;
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

    @Inject
    private Event<AuditLog> logger;
    public User authenticatUser(User loginUser) {

        try{
            System.out.println("The user type is ......"+loginUser.getUserType());
            if(loginUser.getUserType().toString().equals("USER"))
                loginUser.setPassword(encryptText.hash(loginUser.getPassword()));
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        try {
            List<User> users = em.createQuery("FROM User u WHERE u.password=:password AND u.email=:email", User.class)
                .setParameter("password", loginUser.getPassword())
                .setParameter("email", loginUser.getEmail())
                .getResultList();
            for(User user : users){
                System.out.println("The user is "+user.getEmail());
                System.out.println("The login user is "+loginUser.getEmail());
                if(loginUser.getEmail().equals(user.getEmail())){
                    // update the logs
                    AuditLog auditLog = new AuditLog(loginUser.getEmail(),LocalDateTime.now(),"User Login");          
                    logger.fire(auditLog);     
                    return user;
                }                    
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

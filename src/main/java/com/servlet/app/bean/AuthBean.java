package com.servlet.app.bean;

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
import com.servlet.view.enums.UserAction;

@Stateless
@Remote
public class AuthBean extends GenericBean<User> implements AuthBeanI {

    @PersistenceContext
    EntityManager em;

    @Inject
    @PasswordTypeSelector(passwordEnum = PasswordEnum.SHA256)
    private EncryptText encryptText;

    @Inject
    private Event<AuditLog> logger;

    public User authenticatUser(User loginUser) {

        try {
            System.out.println("The user type is ......" + loginUser.getUserType());
            loginUser.setPassword(encryptText.hash(loginUser.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        try {
            List<User> users = list(loginUser);
            for (User user : users) {
                System.out.println("The user is " + user.getEmail());
                System.out.println("The login user is " + loginUser.getEmail());
                if (loginUser.getEmail().equals(user.getEmail())) {
                    // update the logs
                    AuditLog auditLog = new AuditLog(loginUser.getEmail(), LocalDateTime.now(),
                            UserAction.LOGIN.getValue());
                    logger.fire(auditLog);
                    return user;
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

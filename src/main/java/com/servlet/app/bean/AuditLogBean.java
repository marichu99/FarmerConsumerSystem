package com.servlet.app.bean;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.servlet.app.model.entity.AuditLog;


@Stateless
@Remote
public class AuditLogBean implements Serializable{
    @PersistenceContext
    EntityManager em;

    public void updateLog(@Observes AuditLog auditLog){
        System.out.println("A log is being added!!");
        em.merge(auditLog);
    }
}

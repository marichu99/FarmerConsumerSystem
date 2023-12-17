package com.servlet.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.AuditLog;

@Stateless
@Remote
public class AuditBean extends GenericBean<AuditLog> implements AuditLogBeanI {
    
}

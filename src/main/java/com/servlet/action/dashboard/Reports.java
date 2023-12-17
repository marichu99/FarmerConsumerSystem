package com.servlet.action.dashboard;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.bean.AuditLogBeanI;
import com.servlet.app.model.entity.AuditLog;

@WebServlet(urlPatterns = "/reports")
public class Reports extends BaseAction{
    @EJB
    AuditLogBeanI auditBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        renderSpecific(req, resp, AuditLog.class, auditBean.list(new AuditLog()), UserAction.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}

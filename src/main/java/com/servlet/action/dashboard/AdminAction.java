package com.servlet.action.dashboard;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.bean.UserBeanI;
import com.servlet.app.model.entity.User;

@WebServlet(urlPatterns = "/admin")
public class AdminAction extends BaseAction{

    @EJB UserBeanI userBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // renderPage(req, resp, 0, HtmlComponents.form(User.class));
        renderSpecific(req, resp, User.class, userBean.list(new User()) );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    
}

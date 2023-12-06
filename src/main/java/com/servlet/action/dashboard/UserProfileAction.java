package com.servlet.action.dashboard;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.bean.UserBeanI;
import com.servlet.app.model.entity.User;
import com.servlet.view.html.HtmlComponents;
import com.servlet.view.html.UserProfile;
@WebServlet(urlPatterns = "/profile")
public class UserProfileAction extends BaseAction{
    UserProfile userProfile = new UserProfile();
    @EJB
    UserBeanI userBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // check to see whether we have some parameters
        String userGet=StringUtils.trimToEmpty(req.getParameter("get"));
        if(userGet.equals("all")){
            // lets render a table that has all the users in the system

            // new AppPage().renderHtml(req, resp, 0, HtmlComponents.table(userBean.list(), User.class), "");
            renderPage(req, resp, 0, HtmlComponents.table(userBean.allElements(new User()), User.class));
        }else{
        // TODO Auto-generated method stub
            // new AppPage().renderHtml(req, resp, 0, userProfile.getUserProfile(),StringUtils.EMPTY);
            renderPage(req, resp, 0, userProfile.getUserProfile());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}

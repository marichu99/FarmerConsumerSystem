package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.view.css.AllPageCss;
import com.servlet.view.html.AppPage;
import com.servlet.view.html.UserProfile;
@WebServlet(urlPatterns = "/profile")
public class UserProfileAction extends BaseAction{
    UserProfile userProfile = new UserProfile();
    AllPageCss allPageCss = new AllPageCss();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        new AppPage().renderHtml(req, resp, 0, userProfile.getUserProfile(),StringUtils.EMPTY);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}

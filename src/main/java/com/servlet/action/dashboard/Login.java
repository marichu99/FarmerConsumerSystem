package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.app.bean.AuthBean;
import com.servlet.app.bean.AuthBeanI;
import com.servlet.app.model.entity.User;
import com.servlet.view.css.AllPageCss;
import com.servlet.view.enums.UserType;
import com.servlet.view.html.HtmlComponents;
import com.servlet.view.html.UserProfile;

@WebServlet(urlPatterns = "/login")
public class Login extends BaseAction {
    AuthBeanI authBean = new AuthBean();
    UserProfile userProfile = new UserProfile();
    AllPageCss allPageCss = new AllPageCss();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter print = resp.getWriter();
        User loginUser2= serializeForm(User.class, req.getParameterMap());
        User userDetails = authBean.authenticatUser(loginUser2);
        
        
        if (userDetails != null) {
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("loggedInId", new Date().getTime() + "");
            // get the userType of the authenticated user
            UserType userType = userDetails.getUserType();
            httpSession.setAttribute("email", loginUser2.getEmail());
            
            if(userType == UserType.USER && loginUser2.getUserType() == UserType.USER){
                httpSession.setAttribute("userType","user");
                renderPage(req, resp, 0, HtmlComponents.getCustomerDash());
            }else if(userType == UserType.ADMIN && loginUser2.getUserType() == UserType.ADMIN){
                httpSession.setAttribute("userType","admin");
                renderPage(req, resp, 0, HtmlComponents.getCustomerDash());
            }                           

        }
        print.write("<html><body>Invalid login details <a href=\"./login\"> Login again </a></body></html>");
    }

    @Override

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("./login.jsp");
        dispatcher.forward(req, resp);
        // new AppPage().renderHtml(req, resp, 0, HtmlComponents.loginForm(), "");
    }
}

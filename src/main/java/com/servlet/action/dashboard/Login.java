package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.app.bean.AuthBeanI;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.bean.UserBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;
import com.servlet.utils.GlobalBean;
import com.servlet.view.enums.UserType;

@WebServlet(urlPatterns = "/login")
public class Login extends BaseAction {
    @EJB
    AuthBeanI authBean;
    @EJB
    ProductBeanI productBean;
    @EJB
    UserBeanI userBean;
    @Inject
    GlobalBean globalBean;

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
            httpSession.setAttribute("email", userDetails.getEmail());
            globalBean.setUserEmail(userDetails.getEmail());
            
            if(userType == UserType.USER && userDetails.getUserType() == UserType.USER){
                httpSession.setAttribute("userType","user");
                // renderPage(req, resp, 0, HtmlComponents.getCustomerDash());
                renderSpecific(req, resp, Product.class, productBean.list(new Product()));
            }else if(userType == UserType.ADMIN && userDetails.getUserType() == UserType.ADMIN){
                httpSession.setAttribute("userType","admin");
                // renderPage(req, resp, 0, HtmlComponents.getCustomerDash());
                renderSpecific(req, resp, User.class, userBean.list(new User()));
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

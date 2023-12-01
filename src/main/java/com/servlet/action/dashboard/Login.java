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

        // get the user type from the request parameters
        String reqUserType = req.getParameter("usertype");

        // serialize the form
        User loginUser2 = serializeForm(User.class, req.getParameterMap());

        // set the userType of the user that wants to login [USER/ADMIN]
        loginUser2.setUserType(Enum.valueOf(UserType.class, reqUserType));

        // authenticate the user
        User userDetails = authBean.authenticatUser(loginUser2);

        if (userDetails != null) {
            // create a session
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("loggedInId", new Date().getTime() + "");
            // get the userType of the authenticated user
            UserType userType = userDetails.getUserType();
            httpSession.setAttribute("email", userDetails.getEmail());
            // set the user email for the session based bean
            GlobalBean.setUserEmail(userDetails.getEmail());

            boolean isTypeMatching = reqUserType.equals(userType.toString());
            if (isTypeMatching && reqUserType.equals("USER")) {
                httpSession.setAttribute("userType", "user");
                // renderPage(req, resp, 0, HtmlComponents.getCustomerDash());
                renderSpecific(req, resp, Product.class, productBean.list(new Product()));                
            } else if (isTypeMatching && reqUserType.equals("ADMIN")) {
                httpSession.setAttribute("userType", "admin");
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

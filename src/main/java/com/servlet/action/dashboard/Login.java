package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.app.bean.AuthBean;
import com.servlet.app.bean.AuthBeanI;
import com.servlet.app.model.entity.User;
import com.servlet.view.css.AllPageCss;
import com.servlet.view.html.UserProfile;

@WebServlet(urlPatterns = "/login")
public class Login extends BaseAction {
    AuthBeanI authBean = new AuthBean();
    UserProfile userProfile = new UserProfile();
    AllPageCss allPageCss = new AllPageCss();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter print = resp.getWriter();
        User loginUser = new User();
        serializeForm(loginUser, req.getParameterMap());
        // loginUser.setEmail(req.getParameter("email"));
        // loginUser.setPassword(req.getParameter("password"));
        User userDetails = authBean.authenticatUser(loginUser);
        ServletContext ctx = req.getServletContext();
        
        if (userDetails != null) {
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("loggedInId", new Date().getTime() + "");
            httpSession.setAttribute("email", loginUser.getEmail());
            // let us set some objects that are widely used in the servlet context
            ctx.setAttribute("userProfile", userProfile);
            ctx.setAttribute("allPageCss", allPageCss);
            resp.sendRedirect("./home");

        }
        print.write("<html><body>Invalid login details <a href=\".\"> Login again </a></body></html>");

    }

    @Override

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("./login.html");
        dispatcher.forward(req, resp);
    }
}

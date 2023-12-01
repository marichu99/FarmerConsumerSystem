
package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.bean.UserBeanI;
import com.servlet.app.model.entity.User;

@WebServlet(urlPatterns = "/sign")
public class SignUp extends BaseAction {
    @EJB
    UserBeanI userBean;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter print = resp.getWriter();
        User user = serializeForm(User.class, req.getParameterMap());
        // after sign up, the default redirect location is
        String servletPath = req.getServletPath();
        if (userBean.registerUser(user)){
            System.out.println("The Servlet Path is##### "+servletPath);
            if (servletPath.contains("/admin")) {
                print.write("<html>" +
                        "<body>" +
                        "<script type='text/javascript'>" +
                        "    alert('User Added Successfully');" +
                        "    window.location.href = ./home;" +
                        "</script>" +
                        "</body>" +
                        "</html>");
            } else {
                print.write("<html>" +
                        "<body>" +
                        "<script type='text/javascript'>" +
                        "    alert('Thanks for registering with us, Kindly Login using your credentials');" +
                        "    window.location.href = ./login;" +
                        "</script>" +
                        "</body>" +
                        "</html>");
            }
        }
        // action for updating the user
        
    }   


    @Override

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("./Sign.html");
        dispatcher.forward(req, resp);
    }
}

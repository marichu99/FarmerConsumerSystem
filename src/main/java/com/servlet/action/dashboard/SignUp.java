
package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.bean.UserBean;
import com.servlet.app.bean.UserBeanI;
import com.servlet.app.model.entity.User;

@WebServlet(urlPatterns = "/sign")
public class SignUp extends BaseAction {
    UserBeanI userBean = new UserBean();
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter print = resp.getWriter();
        User user = new User();
        serializeForm(user,req.getParameterMap());
        userBean.registerUser(user);
        print.write("<html>" +
                "<body>" +
                "<script type='text/javascript'>" +
                "    alert('Thanks for registering with us, Kindly Login using your credentials');" +
                "    window.location.href = './login.html';" +
                "</script>" +
                "</body>" +
                "</html>");
    }

    @Override

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("./Sign.html");
        dispatcher.forward(req, resp);        
    }
}

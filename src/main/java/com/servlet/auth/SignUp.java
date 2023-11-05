
package com.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.model.entity.User;
import com.servlet.database.Database;

@WebServlet(urlPatterns = "/sign")
public class SignUp extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        PrintWriter print = resp.getWriter();

        Database database = Database.getDbInstance();
        print.write("<html><body>All the users are" + database.getUsers().toString() + "</body></html>");
        database.getUsers().add(new User(email, password, username));
        print.write("<html>" +
                "<body>" +
                "<script type='text/javascript'>" +
                "    alert('Thanks for registering with us, Kindly Login using your credentials');" +
                "    window.location.href = './Login.html';" +
                "</script>" +
                "</body>" +
                "</html>");
        print.write("<html><body>Invalid login details <a href=\".\"> Login again </a></body></html>");

    }

    @Override

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId")))
            resp.sendRedirect("./home");
        else
            resp.sendRedirect("./");
    }
}

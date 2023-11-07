
package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                "    window.location.href = './login.html';" +
                "</script>" +
                "</body>" +
                "</html>");
        print.write("<html><body>Invalid login details <a href=\".\"> Login again </a></body></html>");

    }

    @Override

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("./Sign.html");
        dispatcher.forward(req, resp);        
    }
}

package com.servlet.auth;

import java.io.IOException;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.model.entity.User;
import com.servlet.database.Database;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("loggedInId", new Date().getTime()+"");
        ServletContext ctx = getServletContext();
        // TODO Auto-generated method stub
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        // set the id attribute for the context
        ctx.setAttribute("userId", 1);
        Database database = Database.getDbInstance();
        for(User user : database.getUsers()){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                 // let us set the attributes
                httpSession.setAttribute("loggedInId", new Date().getTime()+"");
                ctx.setAttribute("email", username);
                resp.sendRedirect("./home");
            }
        }
    }

    @Override
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession httpSession = req.getSession();

        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId")))
            resp.sendRedirect("./home");
        else
            resp.sendRedirect("./");
    }    
}

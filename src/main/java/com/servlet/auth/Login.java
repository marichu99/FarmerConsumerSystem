package com.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("loggedInId", new Date().getTime());
        ServletContext ctx = getServletContext();
        // TODO Auto-generated method stub
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        PrintWriter printWriter = resp.getWriter();
        if(username.equals(ctx.getInitParameter("email")) && password.equals(ctx.getInitParameter("password"))){
            printWriter.write("Welcome to Accounting");
            resp.sendRedirect("/home");
        }else{
            printWriter.write("Invalid login details <a href=\".\">Login Again</a>");
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

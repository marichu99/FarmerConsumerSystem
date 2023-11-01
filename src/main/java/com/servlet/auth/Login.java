package com.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/login",initParams = {
    @WebInitParam(name = "email", value = "martin@gmail.com"),
    @WebInitParam(name = "password", value = "mabera")
})
public class Login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        PrintWriter printWriter = resp.getWriter();
        if(username.equals(getInitParameter("email")) && password.equals(getInitParameter("password"))){
            printWriter.write("Welcome to Accounting");
            RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
            dispatcher.forward(req, resp);
        }else{
            printWriter.write("Invalid login details <a href=\".\">Login Again</a>");
        }
    }


    
}

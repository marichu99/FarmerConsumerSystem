package com.servlet.index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/")
public class Home extends HttpServlet { 
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
        PrintWriter printWriter = res.getWriter();
        printWriter.write("<b>Hello world again using post method !!! </b>");

        String username =req.getParameter("usename");
        String password =req.getParameter("password");

        if(username.equals("martin") && password.equals("mabera")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("./app/Home.html");
            dispatcher.forward(req, res);
            printWriter.write("Welcome to the system");
            res.sendRedirect("./app/Home.html");
        }else{
            printWriter.write("<p>Invalid Login <a href='/farmer-system-app'>Login again</a></p>");
        }
    }   
}

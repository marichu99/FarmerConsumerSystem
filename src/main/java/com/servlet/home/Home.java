package com.servlet.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/home")
public class Home extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter printWriter = resp.getWriter();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        resp.sendRedirect("./app/Home.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        PrintWriter printWriter = resp.getWriter();
        // TODO Auto-generated method stub
        HttpSession httpSession = req.getSession();
        String session = (String) httpSession.getAttribute("loggedInId");
        if(StringUtils.isNotBlank(session)){
            printWriter.write("<b>Welcome to the Home Page "+ctx.getAttribute("email")+"</b>+");
            printWriter.write("\n"+
            "You can log out here <a href = \"./logout\"> Logout </a>");
        }else{
            resp.sendRedirect("/");
        }
    }
}

   
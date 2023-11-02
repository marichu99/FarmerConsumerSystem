package com.servlet.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession httpSession = req.getSession();
        if(StringUtils.isNotBlank((String)httpSession.getAttribute("loggedInId"))){
            // invalidate
            httpSession.invalidate();
            resp.sendRedirect("./");
        }
    }
    
}

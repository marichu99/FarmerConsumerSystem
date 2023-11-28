package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.model.entity.User;
import com.servlet.view.html.HtmlComponents;

@WebServlet(urlPatterns = "/admin")
public class AdminAction extends BaseAction{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        renderPage(req, resp, 0, HtmlComponents.form(User.class));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    
}

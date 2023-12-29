package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.bean.UserBeanI;
import com.servlet.app.model.entity.User;

@WebServlet(urlPatterns = "/user")
public class UserAction extends BaseAction{
    @EJB
    UserBeanI userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        // TODO Auto-generated method stub
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));
        
        if(action.equals("delete"))
            // get the user element by Id                        
            userBean.delete((User)userBean.getByID(id, new User()));     
            resp.sendRedirect("./admin");   
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}

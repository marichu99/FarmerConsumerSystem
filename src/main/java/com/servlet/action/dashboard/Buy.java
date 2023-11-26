package com.servlet.action.dashboard;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.model.entity.Product;
import com.servlet.database.MysqlDataBase;
import com.servlet.view.html.HtmlComponents;
@WebServlet(urlPatterns = "/buy")
public class Buy extends BaseAction{
    @EJB
    MysqlDataBase dataBase;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        renderPage(req, resp, 0, HtmlComponents.gridView(dataBase.select(Product.class)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}

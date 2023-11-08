package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.database.Database;
import com.servlet.view.html.AppPage;
import com.servlet.view.html.HtmlComponents;

@WebServlet(urlPatterns = "/cart")
public class CartAction extends BaseAction{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = Database.getDbInstance();
        // TODO Auto-generated method stub
        new AppPage().renderHtml(req, resp, 0, HtmlComponents.cartItems(database.getCartProducts()), "");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}

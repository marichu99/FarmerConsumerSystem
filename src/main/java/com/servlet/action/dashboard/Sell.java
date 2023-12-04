package com.servlet.action.dashboard;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.view.html.HtmlComponents;
@WebServlet(urlPatterns = "/sell")
public class Sell extends BaseAction{
    @EJB
    ProductBeanI productBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // new AppPage().renderHtml(req, resp, 0, HtmlComponents.form(Product.class),"");

        renderPage(req, resp, 0, HtmlComponents.form(Product.class));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);

    }
    
}

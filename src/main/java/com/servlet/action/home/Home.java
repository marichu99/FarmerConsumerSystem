package com.servlet.action.home;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.action.dashboard.BaseAction;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.utils.GlobalBean;

@WebServlet(urlPatterns = "/home")
public class Home extends BaseAction {
    @EJB
    private ProductBeanI productBean;
    @Inject
    private GlobalBean globalBean;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("./app/Home.html");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       

        // new AppPage().renderHtml(req, resp, 0, allHtml.getAllHtml(),allCss.getCssCode());
        renderSpecific(req, resp, Product.class, productBean.list(new Product()));
    }
}

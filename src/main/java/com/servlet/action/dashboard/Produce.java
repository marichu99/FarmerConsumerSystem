package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.bean.ProductBean;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;
import com.servlet.view.html.AppPage;
import com.servlet.view.html.HtmlComponents;

@WebServlet("/produce")
public class Produce extends BaseAction {
    private Product product = new Product();
    private ProductBeanI productBean = new ProductBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // get the existing database instance
        Database dbInstance = Database.getDbInstance();
        
        new AppPage().renderHtml(req, resp, 0, HtmlComponents.gridView(dbInstance.getProducts()),StringUtils.EMPTY);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // get the existing database instance
        Database dbInstance = Database.getDbInstance();

        serializeForm(product, req.getParameterMap());
        try {
            productBean.addOrUpdateProduct(product);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // code to upload a file to the images directory
        // Specify the directory where you want to store the uploaded file
        resp.sendRedirect("./produce");
    }
}

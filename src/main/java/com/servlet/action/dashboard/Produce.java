package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.bean.ProductBean;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;
import com.servlet.view.html.AppPage;

@WebServlet("/produce")
public class Produce extends BaseAction {
    private Product product = new Product();
    private ProductBeanI productBean = new ProductBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // get the existing database instance
        Database dbInstance = Database.getDbInstance();

        String allProduce = "<div class ='prodDetails'>";
        for (Product product : dbInstance.getProducts()) {

            allProduce += "<div class='prod_item'>" +
                    "    <img src='https://www.google.com/url?sa=i&url=https%3A%2F%2Fstock.adobe.com%2Fsearch%3Fk%3Dmaize%2Bgrain&psig=AOvVaw2rA6wS_Q_uKw9iBuACnkOJ&ust=1699402854196000&source=images&cd=vfe&ved=0CBIQjRxqFwoTCMDKuI7PsIIDFQAAAAAdAAAAABAE' class='image_prod'/><br/>"
                    +
                    "    <span class='prodName'>" + product.getProductName() + "</span><br/>" +
                    "    <span class='prodLocation'>" + product.getProductDescription() + "</span><br/>" +
                    "    <span class='prodPrice'>" + product.getPrice() * product.getProdQuantity() + "</span><br/>" +
                    "</div>";
        }
        allProduce += "</div>";
        new AppPage().renderHtml(req, resp, 0, allProduce);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // get the existing database instance
        Database dbInstance = Database.getDbInstance();

        serializeForm(product, req.getParameterMap());

        // code to upload a file to the images directory
        // Specify the directory where you want to store the uploaded file
        resp.sendRedirect("./produce");
    }
}

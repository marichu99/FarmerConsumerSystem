package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;
import com.servlet.view.css.AppCss;
import com.servlet.view.css.ProductCss;
import com.servlet.view.toolbar.TopBar;

@WebServlet("/produce")
public class Produce extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx= getServletContext();
        // TODO Auto-generated method stub
        // get the existing database instance
        Database dbInstance = Database.getDbInstance();
        PrintWriter printWriter = resp.getWriter();
        

        String allProduce =  " ";
        for (Product product : dbInstance.getProducts()) {        

            allProduce+="<div class='prod_item'>" +
                    "    <img src='prodIMG/' class='image_prod'/><br/>" +
                    "    <span class='prodName'>"+product.getProductName()+"</span><br/>" +
                    "    <span class='prodLocation'>"+product.getProductDescription()+"</span><br/>" +
                    "    <span class='prodPrice'>"+product.getPrice()+"</span><br/>" +
                    "</div>";
        }
        printWriter.write("<!DOCTYPE html>" +
            "<html>" +

            "<head>" +
                new ProductCss().getStyles() +
            "</head>" +

            "<body>" );
        printWriter.write(allProduce);
        printWriter.write("<a href=\"./logout\">Logout</a>" +
            "</body>" +
            "</html>");
          
    }
      

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // get the existing database instance
        Database dbInstance = Database.getDbInstance();
        // lets access the produce from the database through the same instance
        dbInstance.getProducts().add(new Product(1, req.getParameter("prodName"), req.getParameter("prodDescription"),
                Double.valueOf(req.getParameter("prodPrice")), Integer.parseInt(req.getParameter("prodQuantity"))));
    }
}

package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.bean.CartBean;
import com.servlet.app.bean.CartBeanI;
import com.servlet.app.bean.ProductBean;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;

@WebServlet("/produce")
public class Produce extends BaseAction {
    private ProductBeanI productBean = new ProductBean();
    private CartBeanI cartBean = new CartBean();
    Database database = Database.getDbInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String type = StringUtils.trimToEmpty(req.getParameter("type"));
        String mode = StringUtils.trimToEmpty(req.getParameter("mode"));
        PrintWriter printWriter = resp.getWriter();
        if (type.equals("product") && mode.equals("remove")) {
            // get the id that has been passed
            if (StringUtils.isNotBlank(req.getParameter("productID"))) {
                // remove by the id
                productBean.deleteProduct(Integer.parseInt(req.getParameter("productID")));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                resp.sendRedirect("./app/produce.jsp");
            }
        }else if(type.equals("cart") && mode.equals("remove")){
            // get the id
            int productID = Integer.parseInt(req.getParameter("productID"));
            // delete the product using the id
            cartBean.removeByID(productID);
            printWriter.write("<html>" +
                "<body>" +
                "<script type='text/javascript'>" +
                "    alert('Thanks for registering with us, Kindly Login using your credentials');" +
                "    window.location.href = './produce';" +
                "</script>" +
                "</body>" +
                "</html>");
            resp.sendRedirect("./app/produce.jsp");
        }
      
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // get the existing database instance
        // check if we have a product that needs to be updated first

        String mode = StringUtils.trimToEmpty(req.getParameter("product"));
        if (StringUtils.isNotBlank(mode)) {
            if (mode.equals("update")) {
                // lets get the ID from the parameter map
                int productID = Integer.parseInt(req.getParameter("productId"));
                // serialize the form first
                Product product = serializeForm(Product.class, req.getParameterMap());
                // then run the update by id methos
                productBean.updateByID(productID, product);
            }
        } else {
            // if no update then create a new product
            Product product = serializeForm(Product.class, req.getParameterMap());
            try {
                // database.getProducts().add(product);
                productBean.addOrUpdateProduct(product);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // Specify the directory where you want to store the uploaded file
        resp.sendRedirect("./app/produce.jsp");
    }
}

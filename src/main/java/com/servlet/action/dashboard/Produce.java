package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.bean.CartBeanI;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.database.MysqlDataBase;
import com.servlet.view.html.HtmlComponents;

@WebServlet("/produce")
public class Produce extends BaseAction {
    @EJB
    private ProductBeanI productBean;
    @EJB
    private CartBeanI cartBean;
    // Database database = Database.getDbInstance();
    @EJB
    MysqlDataBase database;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String type = StringUtils.trimToEmpty(req.getParameter("type"));
        String mode = StringUtils.trimToEmpty(req.getParameter("mode"));
        PrintWriter printWriter = resp.getWriter();
        if (type.equals("product") && mode.equals("remove")) {
            // get the id that has been passed
            if (StringUtils.isNotBlank(req.getParameter("productID"))) {
                int productID = Integer.parseInt(req.getParameter("productID"));
                // remove by the id
                // get the product by ID
                Product product = productBean.getProductByID(productID);
                System.out.println("############## Product Name "+product.getProductName());

                productBean.delete(product,productID);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }else if(type.equals("cart") && mode.equals("remove")){
            // get the id
            int productID = Integer.parseInt(req.getParameter("productID"));
            // delete the product using the id
            cartBean.removeByID(productID);
            printWriter.write("<html>" +
                "<body>" +
                "<script type='text/javascript'>" +
                "    alert('Item has been removed successfully');" +
                "    window.location.href = './produce';" +
                "</script>" +
                "</body>" +
                "</html>");
        }
        renderPage(req, resp, 0, HtmlComponents.gridView(productBean.list(new Product())));
        // renderSpecific(req, resp, Product.class, productBean.list());
      
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
                productBean.addOrUpdate(product);
                // 
                resp.sendRedirect("./produce");
                // renderSpecific(req, resp, Product.class, productBean.list());
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // Specify the directory where you want to store the uploaded file
        // resp.sendRedirect("./produce");
    }
}

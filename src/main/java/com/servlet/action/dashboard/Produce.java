package com.servlet.action.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.bean.CartBeanI;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.utils.GlobalBean;
import com.servlet.view.enums.ProductCategory;

@WebServlet("/produce")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024
        * 100)
public class Produce extends BaseAction {
    @EJB
    private ProductBeanI productBean;
    @EJB
    private CartBeanI cartBean;

    @EJB
    GlobalBean globalBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the httpSession
        HttpSession httpSession = req.getSession();

        String type = StringUtils.trimToEmpty(req.getParameter("type"));
        String mode = StringUtils.trimToEmpty(req.getParameter("mode"));
        PrintWriter printWriter = resp.getWriter();
        if (type.equals("product") && mode.equals("remove")) {
            // get the id that has been passed
            if (StringUtils.isNotBlank(req.getParameter("id"))) {
                int productID = Integer.parseInt(req.getParameter("id"));
                // remove by the id
                // get the product by ID
                Product product = productBean.getProductByID(productID);
                System.out.println("############## Product Name " + product.getProductName());

                productBean.delete(product);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else if (type.equals("cart") && mode.equals("remove")) {
            // get the id
            int productID = Integer.parseInt(req.getParameter("productID"));
            // delete the product using the id
            cartBean.removeByID(productID);
            printWriter.write("<html>" +
                    "<body>" +
                    "<script type='text/javascript'>" +
                    "    alert('Item has been removed successfully');" +
                    "    window.location.href = './cart';" +
                    "</script>" +
                    "</body>" +
                    "</html>");
        }
        
        Product product = new Product();

        // for normal users
        if (httpSession.getAttribute("userType").equals("user")) {
            product.setProductOwner(GlobalBean.getUserEmail());
            renderSpecific(req, resp, Product.class, productBean.list(product), ProductCategory.class);
        } else {
            renderSpecific(req, resp, Product.class, productBean.list(product), ProductCategory.class);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = StringUtils.trimToEmpty(req.getParameter("Product"));
        System.out.println("The mode is ####" + mode);
        if (StringUtils.isNotBlank(mode)) {
            if (mode.equals("update")) {
                // lets get the ID from the parameter map
                int productID = Integer.parseInt(req.getParameter("id"));
                // serialize the form first
                Product product = serializeForm(Product.class, req.getParameterMap());
                // add the product owner and the product ID to the product object
                product.setProductOwner(GlobalBean.getUserEmail());
                product.setId(productID);
                System.out.println("The product owner is ##" + product.getProductOwner());
                // then run the update by id methos
                productBean.addOrUpdate(product);
                resp.sendRedirect("./produce");
            }
        } else {
            // get image data
            String imageName = req.getPart("file").getSubmittedFileName();
            Part filePart = req.getPart("file");

            // upload
            for (Part part : req.getParts()) {
                part.write("/home/mabera/Documents/FarmerConsumerSystem/src/main/webapp/images/" + imageName);
            }

            // if no update then create a new product
            Product product = serializeForm(Product.class, req.getParameterMap());
            // set the user
            product.setProductOwner(GlobalBean.getUserEmail());
            // set the image name
            product.setImageName(imageName);

            System.out.println("The image name is ##" + imageName);
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

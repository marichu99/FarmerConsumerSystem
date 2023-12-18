package com.servlet.action.dashboard;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.bean.AuditLogBeanI;
import com.servlet.app.bean.CartBeanI;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.utils.GlobalBean;
import com.servlet.view.enums.ProductCategory;

@WebServlet("/produce")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024
        * 100)
public class ProductAction extends BaseAction {
    @EJB
    ProductBeanI productBean;

    @EJB
    private CartBeanI cartBean;

    @EJB
    GlobalBean globalBean;

    @EJB
    AuditLogBeanI auditLogBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product product = new Product();

        // get the httpSession
        HttpSession httpSession = req.getSession();

        String type = StringUtils.trimToEmpty(req.getParameter("type"));
        String mode = StringUtils.trimToEmpty(req.getParameter("mode"));
        String value = StringUtils.trimToEmpty(req.getParameter("value"));
        String search = StringUtils.trimToEmpty(req.getParameter("search"));
        String category = StringUtils.trimToEmpty(req.getParameter("category"));

        if (type.equals("product")) {
            if (mode.equals("remove")) {

                // get the id that has been passed
                if (StringUtils.isNotBlank(req.getParameter("id"))) {
                    int productID = Integer.parseInt(req.getParameter("id"));

                    // get the product by ID
                    product = productBean.getProductByID(productID);

                    productBean.delete(product);

                }
            } else if (mode.equals("all")) {
                // get all products
                Product thisProduct = new Product();

                GlobalBean.setShowButtons(true);

                List<Product> allProducts = productBean.list(thisProduct);

                // check for category for all the products
                if (StringUtils.isNotBlank(category)) {
                    searchByCategory(req, resp, category, allProducts, mode, search, value, thisProduct);
                } else {
                    // check whether an addional search param has been implemented
                    allProducts = searchByName(search, allProducts);

                    toRender(req, resp, Product.class, allProducts, ProductCategory.class);
                }

            } else if (mode.equals("mine")) {

                Product productNew = new Product();
                // get the current user's products
                productNew.setProductOwner(GlobalBean.getUserEmail());

                List<Product> allProducts = productBean.list(productNew);

                GlobalBean.setShowButtons(false);

                // check for the category for this current user
                if (StringUtils.isNotBlank(category)) {
                    searchByCategory(req, resp, category, allProducts, mode, search, value, productNew);
                } else {

                    // check whether an addional search param has been implemented
                    allProducts = searchByName(search, allProducts);
                    toRender(req, resp, Product.class, allProducts, ProductCategory.class);
                }

            }

        } else if (type.equals("cart") && mode.equals("remove")) {
            // get the id
            int productID = Integer.parseInt(req.getParameter("productID"));

            // delete the product using the id
            cartBean.removeByID(productID);

        }

        // get the search params
        searchByCategory(req, resp, category, productBean.list(new Product()), mode, search, value, new Product());

        // for normal users
        if (httpSession.getAttribute("userType").equals("user")) {

            Product product2 = new Product();
            product2.setProductOwner(GlobalBean.getUserEmail());

            toRender(req, resp, Product.class, productBean.list(product2), ProductCategory.class);
        } else {

            toRender(req, resp, Product.class, productBean.list(product), ProductCategory.class);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mode = StringUtils.trimToEmpty(req.getParameter("Product"));

        if (StringUtils.isNotBlank(mode)) {
            if (mode.equals("update")) {
                // lets get the ID from the parameter map
                int productID = Integer.parseInt(req.getParameter("id"));

                // serialize the form first
                Product product = serializeForm(Product.class, req.getParameterMap());

                // add the product owner and the product ID to the product object
                product.setProductOwner(GlobalBean.getUserEmail());
                product.setId(productID);

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

            try {
                productBean.addOrUpdate(product);
                //
                resp.sendRedirect("./produce");
                // toRender(req, resp, Product.class, productBean.list());

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public List<Product> searchByName(String search, List<Product> allProducts) {
        if (StringUtils.isNotBlank(search)) {
            System.out.println("The searcg value is " + search);
            allProducts = productBean.searchByName(search, allProducts);
        }
        return allProducts;
    }

    public void searchByCategory(HttpServletRequest req, HttpServletResponse resp, String category,
            List<Product> allProducts, String mode, String search, String value, Product thisProduct) {
        if (category.equals("ProductCategory")) {

            thisProduct.setProductCategory(Enum.valueOf(ProductCategory.class, value));

            if (mode.equals("mine")) {
                thisProduct.setProductOwner(GlobalBean.getUserEmail());
            }
            // check whether an addional search param has been implemented
            allProducts = searchByName(search, allProducts);

            toRender(req, resp, Product.class, allProducts, ProductCategory.class);
        } else if (!category.equals("ProductCategory") && StringUtils.isNotBlank(search)) {
            thisProduct.setProductOwner(GlobalBean.getUserEmail());

            // check whether an addional search param has been implemented
            allProducts = searchByName(search, allProducts);

            toRender(req, resp, Product.class, allProducts, ProductCategory.class);
        }
    }

    public void toRender(HttpServletRequest req, HttpServletResponse resp, Class<?> entityClazz,
            List<Product> renderedProducts, Class<?> selectClazz) {
        try {
            renderSpecific(req, resp, Product.class, renderedProducts, ProductCategory.class);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

package com.servlet.action.home;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.action.dashboard.BaseAction;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.utils.GlobalBean;
import com.servlet.view.enums.ProductCategory;

@WebServlet(urlPatterns = "/home")
public class Home extends BaseAction {
    @EJB
    private ProductBeanI productBean;

    @PersistenceContext
    EntityManager em;

    @EJB
    GlobalBean globalBean;

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

        @SuppressWarnings({ "rawtype" })

        // get the request parameters if any
        String type = StringUtils.trimToEmpty(req.getParameter("type"));
        String value = StringUtils.trimToEmpty(req.getParameter("value"));

        if (type.equals("productType")) {
            Product product = new Product();
            product.setProductCategory(Enum.valueOf(ProductCategory.class, value));
            product.setProductOwner(GlobalBean.getUserEmail());
            List<Product> allProducts = productBean.list(product);

            String baseUrl = "http://localhost:8080/farmer-system-app/rest" + req.getServletPath() + "/list";
            String queryParams = req.getQueryString();
            String fullUrl = "";
            if (StringUtils.isNotBlank(queryParams)) {
                fullUrl = baseUrl.concat("?").concat(queryParams).toString();
            }
            // update the globalbean and set the endpoint
            GlobalBean.setEndpoint(fullUrl);

            // JsonFetcher.convertJsonToExcel(Product.class, allProducts);

            renderSpecific(req, resp, Product.class, allProducts);
        } else {
            renderSpecific(req, resp, Product.class, productBean.allElements(new Product()));
        }
    }
}

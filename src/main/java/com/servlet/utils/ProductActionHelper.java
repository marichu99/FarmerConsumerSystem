package com.servlet.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.servlet.action.dashboard.ProductAction;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.view.enums.ProductCategory;

public class ProductActionHelper extends ProductAction{

    @EJB 
    ProductBeanI productBean;

    // ... Other existing methods ...

    public void handleProductAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String type = StringUtils.trimToEmpty(req.getParameter("type"));
        String mode = StringUtils.trimToEmpty(req.getParameter("mode"));
        String value = StringUtils.trimToEmpty(req.getParameter("value"));

        PrintWriter printWriter = resp.getWriter();

        if ("product".equals(type)) {
            handleProductActionMode(mode, req, resp);
        } else if ("cart".equals(type) && "remove".equals(mode)) {
            handleCartRemoveAction(req, resp);
        }

        handleSearchParams(req, resp, type, value);
    }

    private void handleProductActionMode(String mode, HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        if ("remove".equals(mode)) {
            handleProductRemoveAction(req, resp);
        } else if ("all".equals(mode)) {
            handleAllProductsAction(req, resp);
        } else if ("mine".equals(mode)) {
            handleUserProductsAction(req, resp);
        }
    }

    private void handleProductRemoveAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Existing logic for removing a product
    }

    private void handleAllProductsAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Existing logic for handling all products
    }

    private void handleUserProductsAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Existing logic for handling user's products
    }

    private void handleCartRemoveAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Existing logic for removing a product from the cart
    }

    private void handleSearchParams(HttpServletRequest req, HttpServletResponse resp, String type, String value) {
        String endPoint = GlobalBean.getEndpoint();
        String[] queryParams = endPoint.split("&");
        HttpSession httpSession = req.getSession();

        if ("ProductCategory".equals(type)) {
            handleProductCategorySearch(req, resp, value);
        } else if ("UserAction".equals(type)) {
            handleUserActionSearch(req, resp, value);
        } else {
            handleDefaultSearch(req, resp);
        }

        // Additional logic for normal users
        if ("user".equals(httpSession.getAttribute("userType"))) {
            handleNormalUserSearch(req, resp);
        }
    }

    private void handleProductCategorySearch(HttpServletRequest req, HttpServletResponse resp, String value) {
        // Existing logic for handling product category search
    }

    private void handleUserActionSearch(HttpServletRequest req, HttpServletResponse resp, String value) {
        // Existing logic for handling user action search
    }

    private void handleDefaultSearch(HttpServletRequest req, HttpServletResponse resp) {
        Product thisProduct = new Product();
        thisProduct.setProductOwner(GlobalBean.getUserEmail());
        try {
            renderSpecific(req, resp, Product.class, productBean.list(thisProduct), ProductCategory.class);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void handleNormalUserSearch(HttpServletRequest req, HttpServletResponse resp) {
        Product product2 = new Product();
        product2.setProductOwner(GlobalBean.getUserEmail());
        try {
            renderSpecific(req, resp, Product.class, productBean.list(product2), ProductCategory.class);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // ... Other existing methods ...
}


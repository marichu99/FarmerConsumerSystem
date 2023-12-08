package com.servlet.action.dashboard;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.bean.CartBeanI;
import com.servlet.app.model.entity.CartProduct;
import com.servlet.view.html.HtmlComponents;

@WebServlet(urlPatterns = "/cart")
public class CartAction extends BaseAction{
    @EJB
    CartBeanI cartBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // TODO Auto-generated method stub
        // check if there are instances where one wants to add or remove carted products
        String mode =StringUtils.trimToEmpty(req.getParameter("mode"));
        if(mode.equals("add")){
            // then get the productID
            int productId = Integer.parseInt(req.getParameter("id"));
            boolean isItemAdded = cartBean.addToCart(productId);
            if(isItemAdded){
                req.setAttribute("Source", "./js/form.js");
                renderPage(req, resp, 0, HtmlComponents.cartItems(cartBean.allElements(new CartProduct())));
            }
        }else{
            renderPage(req, resp, 0, HtmlComponents.cartItems(cartBean.allElements(new CartProduct())));
        }       

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
    
}

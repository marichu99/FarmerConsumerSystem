package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.bean.CartBean;
import com.servlet.app.bean.CartBeanI;
import com.servlet.view.html.HtmlComponents;

@WebServlet(urlPatterns = "/cart")
public class CartAction extends BaseAction{
    CartBeanI cartBean = new CartBean();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // TODO Auto-generated method stub
        // new AppPage().renderHtml(req, resp, 0, HtmlComponents.cartItems(database.getCartProducts()), "");
        // check if there are instances where one wants to add or remove carted products
        String mode =StringUtils.trimToEmpty(req.getParameter("mode"));
        if(mode.equals("add")){
            // then get the productID
            int productId = Integer.parseInt(req.getParameter("productId"));
            boolean isItemAdded = cartBean.addToCart(productId);
            if(isItemAdded){
                renderPage(req, resp, 0, HtmlComponents.cartItems(cartBean.getAllCarts()));
            }
        }else{
            renderPage(req, resp, 0, HtmlComponents.cartItems(cartBean.getAllCarts()));
            // new AppPage().renderHtml(req, resp, 0, HtmlComponents.cartItems(cartBean.getAllCarts()), "");
        }       

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
    
}

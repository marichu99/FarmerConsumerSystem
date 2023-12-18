package com.servlet.app.bean;

import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.servlet.app.model.entity.AuditLog;
import com.servlet.app.model.entity.CartProduct;
import com.servlet.app.model.entity.Product;
import com.servlet.utils.GlobalBean;
import com.servlet.view.enums.UserAction;

@Stateless
@Remote
public class CartBean extends GenericBean<CartProduct> implements CartBeanI {

    @PersistenceContext
    EntityManager em;

    @EJB
    private ProductBeanI productBean;

    @Inject
    private Event<AuditLog> logger;

    @Override
    public boolean addToCart(int productID) {
        // loop through all the products
        for (Product product : productBean.allElements(new Product())) {
            if (product.getId() == productID) {

                // then add it to the cart products list
                CartProduct cartProduct = new CartProduct(product.getProductName(), product.getPrice(),
                        product.getProdQuantity(), product.getProductDescription(), product.getProductOwner());

                cartProduct.setProductCategory(product.getProductCategory());
                cartProduct.setImageName(product.getImageName());        
                getGenericDao().addOrUpdate(cartProduct);

                productBean.delete(product);

                // update logs
                AuditLog auditLog = new AuditLog(GlobalBean.getUserEmail(), LocalDateTime.now(),
                        UserAction.ADD_TO_CART.getValue());
                logger.fire(auditLog);

                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    @Override
    public boolean removeByID(int productId) {
        for (CartProduct cartProduct : getGenericDao().allElements(new CartProduct())) {
            if (cartProduct.getId() == productId) {
                // then add it back to the products list
                Product product = new Product(cartProduct.getId(), cartProduct.getProdName(),
                        cartProduct.getProdDescription(), cartProduct.getProdPrice(), cartProduct.getProdQuantity());

                product.setProductOwner(cartProduct.getProductOwner());
                product.setImageName(cartProduct.getImageName());

                productBean.addOrUpdate(product);

                System.out.println("The product name is " + product.getProductName());
                System.out.println("The product ID is " + product.getId());
                System.out.println("The product description is " + product.getProductDescription());
                // remove the matching element
                getGenericDao().delete(cartProduct);

                return true;
            }
        }
        // TODO Auto-generated method stub
        return false;
    }

}

package com.servlet.app.bean;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.servlet.app.model.entity.CartProduct;
import com.servlet.app.model.entity.Product;

@Stateless
@Remote
public class CartBean extends GenericBean<CartProduct>implements CartBeanI{

    @PersistenceContext
    EntityManager em;
    @EJB
    private ProductBeanI productBean;

    @Override
    public boolean addToCart(int productID) {
        // loop through all the products
        for(Product product: productBean.list(new Product())){
            if(product.getId() == productID){
                
                // then add it to the cart products list
                CartProduct cartProduct = new CartProduct(productID, product.getProductName(), product.getPrice(), product.getProdQuantity(), product.getProductDescription());
                getGenericDao().addOrUpdate(cartProduct);
                
                productBean.delete(product, productID);
                
                return true;
            }else{
                continue;
            }
        }
        return false;
    }

    @Override
    public boolean removeByID(int productId) {
        for(CartProduct cartProduct: getGenericDao().list(new CartProduct())){
            if(cartProduct.getId() == productId){
                // then add it back to the products list
                Product product = new Product(cartProduct.getId(),cartProduct.getProdName(),cartProduct.getProdDescription(),cartProduct.getProdPrice(),cartProduct.getProdQuantity());
                productBean.addOrUpdate(product);

                System.out.println("The product name is "+product.getProductName());
                System.out.println("The product ID is "+product.getId());
                System.out.println("The product description is "+product.getProductDescription());
                // remove the matching element
                getGenericDao().delete(cartProduct, productId);
                
                return true;
            }
        }
        // TODO Auto-generated method stub
        return false;
    }

    
}

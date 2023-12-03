package com.servlet.app.bean;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.CartProduct;
import com.servlet.app.model.entity.Product;
import com.servlet.database.MysqlDataBase;

@Stateless
@Remote
public class CartBean extends GenericBean<CartProduct>implements CartBeanI{
    @EJB
    MysqlDataBase dataBase;
    @Override
    public boolean addToCart(int productID) {
        // loop through all the products
        for(Product product: dataBase.select(Product.class)){
            if(product.getProductId() == productID){
                
                // then add it to the cart products list
                CartProduct cartProduct = new CartProduct(productID, product.getProductName(), product.getPrice(), product.getProdQuantity(), product.getProductDescription());
                dataBase.insert(cartProduct);
                
                dataBase.delete(product, productID);
                
                return true;
            }else{
                continue;
            }
        }
        return false;
    }

    @Override
    public boolean removeByID(int productId) {
        for(CartProduct cartProduct: dataBase.select(CartProduct.class)){
            if(cartProduct.getProductId() == productId){
                // then add it back to the products list
                Product product = new Product(cartProduct.getProductId(),cartProduct.getProdName(),cartProduct.getProdDescription(),cartProduct.getProdPrice(),cartProduct.getProdQuantity());
                dataBase.insert(product);

                System.out.println("The product name is "+product.getProductName());
                System.out.println("The product ID is "+product.getProductId());
                System.out.println("The product description is "+product.getProductDescription());
                // remove the matching element
                dataBase.delete(cartProduct, productId);
                
                return true;
            }
        }
        // TODO Auto-generated method stub
        return false;
    }

    
}

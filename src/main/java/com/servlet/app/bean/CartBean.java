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
                // remove the product from the products list
                dataBase.delete(product, productID);
                // then add it to the cart products list
                CartProduct cartProduct = (CartProduct)product;
                dataBase.insert(cartProduct);
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
                // remove the matching element
                dataBase.delete(cartProduct, productId);
                // then add it back to the products list
                Product product = (Product)cartProduct;
                dataBase.insert(product);;
                return true;
            }
        }
        // TODO Auto-generated method stub
        return false;
    }

    
}

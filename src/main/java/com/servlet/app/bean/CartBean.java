package com.servlet.app.bean;

import java.util.List;

import com.servlet.app.model.entity.CartProduct;
import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;

public class CartBean implements CartBeanI{
private  Database database = Database.getDbInstance();
    @Override
    public List<CartProduct> getAllCarts() {
       
        // TODO Auto-generated method stub
        return database.getCartProducts();
    }

    @Override
    public boolean addToCart(int productID) {
        // loop through all the products
        for(Product product: database.getProducts()){
            if(product.getProductId() == productID){
                // remove the product from the products list
                database.getProducts().remove(product);
                // then add it to the cart products list
                database.getCartProducts().add(new CartProduct(productID, product.getProductName(), product.getPrice(), product.getProdQuantity(),product.getProductDescription()));
                return true;
            }else{
                continue;
            }
        }
        return false;
    }

    @Override
    public boolean removeByID(int productId) {
        for(CartProduct cartProduct:database.getCartProducts()){
            if(cartProduct.getProductId() == productId){
                // remove the matching element
                database.getCartProducts().remove(cartProduct);
                // then add it back to the products list
                database.getProducts().add(new Product(cartProduct.getProductId(),cartProduct.getProdName(),cartProduct.getProdDescription(),cartProduct.getProdPrice(),cartProduct.getProdQuantity()));
                return true;
            }
        }
        // TODO Auto-generated method stub
        return false;
    }

    
}

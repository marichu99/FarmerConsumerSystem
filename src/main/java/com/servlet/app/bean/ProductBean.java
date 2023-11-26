package com.servlet.app.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.Product;

@Stateless
@Remote
public class ProductBean extends GenericBean<Product> implements ProductBeanI{

    public void updateByID(int productID,Product productUpdate){        
        for(Product product: getGenericDao().getDatabase().select(Product.class)){
            if(productID == product.getProductId()){
                // lets update the product then
                database.delete(productUpdate, productID);
                // and replace it with the new product
                database.insert(productUpdate);
                break;
            }else{
                // otherwise continue
                continue;
            } 
        }
    }
     public Product getProductByID(int productID){
        List<Product> products = database.select(Product.class);
        for(Product product: products){
            if(product.getProductId() == productID){
                return product;
            }
        }
        return null;                          
    }

    public void deleteProduct(int productID) {
        for(Product product: database.select(Product.class)){
            if(productID == product.getProductId()){
                // lets update the product then
                database.delete(product, productID);
                break;
            }else{
                // otherwise continue
                continue;
            } 
        }
    }    
}

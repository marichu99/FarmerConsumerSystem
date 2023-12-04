package com.servlet.app.bean;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.Product;

@Stateless
@Local
public class ProductBean extends GenericBean<Product> implements ProductBeanI{

    public void updateByID(int productID,Product productUpdate){        
        for(Product product: getGenericDao().list(new Product())){
            if(productID == product.getProductId()){
                // lets update the product then
                getGenericDao().delete(productUpdate, productID);
                // and replace it with the new product
                getGenericDao().addOrUpdate(productUpdate);
                break;
            }else{
                // otherwise continue
                continue;
            } 
        }
    }
     public Product getProductByID(int productID){
        List<Product> products = getGenericDao().list(new Product());
        for(Product product: products){
            if(product.getProductId() == productID){
                return product;
            }
        }
        return null;                          
    }

    public void deleteProduct(int productID) {
        for(Product product: getGenericDao().list(new Product())){
            if(productID == product.getProductId()){
                // lets update the product then
                getGenericDao().delete(product, productID);
                break;
            }else{
                // otherwise continue
                continue;
            } 
        }
    }    
}

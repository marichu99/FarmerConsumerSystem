package com.servlet.app.bean;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;

@Stateless
@Remote
public class ProductBean extends GenericBean<Product> implements ProductBeanI{
    private Database database = Database.getDbInstance();

    @PostConstruct
    public void init(){
        System.out.println("A bean has been created");
    }

    public void updateByID(int productID,Product productUpdate){        
        for(Product product: database.getProducts()){
            if(productID == product.getProductId()){
                // lets update the product then
                database.getProducts().remove(product);
                // and replace it with the new product
                database.getProducts().add(productUpdate);
                break;
            }else{
                // otherwise continue
                continue;
            } 
        }
    }
     public Product getProductByID(int productID){
        for(Product product: Database.getDbInstance().getProducts()){
            if(product.getProductId() == productID){
                return product;
            }
        }
        return null;                          
    }

    public void deleteProduct(int productID) {
        for(Product product: database.getProducts()){
            if(productID == product.getProductId()){
                // lets update the product then
                database.getProducts().remove(product);
                break;
            }else{
                // otherwise continue
                continue;
            } 
        }
    }
    
}

package com.servlet.app.bean;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.Product;

@Stateless
@Local
public class ProductBean extends GenericBean<Product> implements ProductBeanI{



    public void updateByID(int productID,Product productUpdate){        
        for(Product product: getGenericDao().allElements(new Product())){
            if(productID == product.getId()){
                System.out.println("The name of the product is "+product.getProductName());
                // lets update the product then
                getGenericDao().delete(productUpdate);
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
        List<Product> products = getGenericDao().allElements(new Product());
        for(Product product: products){
            if(product.getId() == productID){
                return product;
            }
        }
        return null;                          
    }

    public void deleteProduct(int productID) {
        for(Product product: getGenericDao().allElements(new Product())){
            if(productID == product.getId()){
                // lets update the product then
                getGenericDao().delete(product);
                break;
            }else{
                // otherwise continue
                continue;
            } 
        }
    }
    @Override
    public List<Product> selectByUser(Product entity, String email) {

        List<Product> allProducts = getGenericDao().allElements(new Product());
        for(int i =0; i<allProducts.size();i++){
            if(!allProducts.get(i).getProductOwner().equals(email)){
                allProducts.remove(i);
            }
        }
        return allProducts;
    }    
}

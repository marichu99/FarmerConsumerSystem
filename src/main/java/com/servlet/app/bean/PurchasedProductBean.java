package com.servlet.app.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.PurchasedProduct;


@Stateless
@Remote
public class PurchasedProductBean extends GenericBean<PurchasedProduct>  implements PurchasedProductBeanI{
    @Override
    public List<PurchasedProduct> searchByName(String productName, List<PurchasedProduct> products) {
        
        List<PurchasedProduct> searchedProducts = new ArrayList<>();
        for(PurchasedProduct product : products){
            if(product.getProductName().equals(productName)){
                System.out.println("A product has been found");
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }
}

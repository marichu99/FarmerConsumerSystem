package com.servlet.app.bean;

import com.servlet.app.model.entity.Product;
public interface ProductBeanI extends GenericBeanI<Product>{
    void deleteProduct(int productID);
    Product getProductByID(int productID);
    void updateByID(int productID, Product product);
}

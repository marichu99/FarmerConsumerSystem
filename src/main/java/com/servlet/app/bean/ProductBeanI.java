package com.servlet.app.bean;

import java.util.List;

import com.servlet.app.model.entity.Product;
public interface ProductBeanI extends GenericBeanI<Product>{
    void deleteProduct(int productID);

    Product getProductByID(int productID);

    void updateByID(int productID, Product product);

    List<Product> selectByUser(Product entity, String email);

    List<Product> searchByName(String productName, List<Product> products);

    List<Product> otherUser(String email, List<Product> products);
}


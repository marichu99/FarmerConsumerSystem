package com.servlet.app.bean;

import java.util.List;

import com.servlet.app.model.entity.Product;

public interface ProductBeanI {

    String productList();

    Product addOrUpdateProduct(Product product) throws Exception;

    void deleteProduct(int productID);

    void updateByID(int productID, Product product);

    List<Product> list();
}

package com.servlet.app.bean;

import com.servlet.app.model.entity.Product;

public interface ProductBeanI {

     String productList();

    Product addOrUpdateProduct(Product product) throws Exception;

    void deleteAccount(Product product);
}

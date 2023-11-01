package com.servlet.app.bean;

import com.servlet.app.model.Product;

public interface ProductBean {

     String productList();

    Product addOrUpdateAccount(Product product) throws Exception;

    void deleteAccount(Product product);
}

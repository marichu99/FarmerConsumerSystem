package com.servlet.app.bean;

import java.util.List;

import com.servlet.app.model.entity.PurchasedProduct;

public interface PurchasedProductBeanI extends GenericBeanI<PurchasedProduct> {
    
    List<PurchasedProduct> searchByName(String productName, List<PurchasedProduct> products);
}

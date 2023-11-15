package com.servlet.app.bean;

import java.util.List;

import com.servlet.app.model.entity.CartProduct;

public interface CartBeanI {
    List<CartProduct> getAllCarts();

    boolean addToCart(int productId);

    boolean removeByID(int productId);
} 
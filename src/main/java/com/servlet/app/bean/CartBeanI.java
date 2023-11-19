package com.servlet.app.bean;

import com.servlet.app.model.entity.CartProduct;

public interface CartBeanI extends GenericBeanI<CartProduct>{

    boolean addToCart(int productId);

    boolean removeByID(int productId);
} 
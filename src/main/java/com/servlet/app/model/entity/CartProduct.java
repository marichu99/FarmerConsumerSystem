package com.servlet.app.model.entity;

import java.io.Serializable;

public class CartProduct implements Serializable{
    private String prodName;
    private Double prodPrice;
    private int prodQuantity;
    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    public Double getProdPrice() {
        return prodPrice;
    }
    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }
    public int getProdQuantity() {
        return prodQuantity;
    }
    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }
    public CartProduct(String prodName, Double prodPrice, int prodQuantity) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodQuantity = prodQuantity;
    }
    
}

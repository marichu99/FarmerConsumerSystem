package com.servlet.app.model.entity;

import java.text.DecimalFormat;
import org.apache.commons.lang3.StringUtils;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private double price;
    private int prodQuantity;
    public int getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public Product() {
    }

    public Product(int id, String name, String description, double price, int prodQuantity) {
        this.productId = id;
        this.productName = name;
        this.productDescription = description;
        this.price = price;
        this.prodQuantity =prodQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String displayProducts() {
        StringBuilder trBuilder = new StringBuilder();
    
        trBuilder.append("<div class=\"prod_item\">");
        // trBuilder.append("<img src='prodIMG/").append(getProductImageDir()).append("' class=\"image_prod\"/><br/>");
        trBuilder.append("<span class=\"prodName\">").append(StringUtils.trimToEmpty(getProductName())).append("</span><br/>");
        trBuilder.append("<span class=\"prodLocation\">").append(getProductDescription()).append("</span><br/>");
        trBuilder.append("<span class=\"prodPrice\">").append(new DecimalFormat("#,###.##").format(getPrice())).append(" Per Kilogram</span><br/>");
        trBuilder.append("</div>");
        return trBuilder.toString();
    }   
    
}
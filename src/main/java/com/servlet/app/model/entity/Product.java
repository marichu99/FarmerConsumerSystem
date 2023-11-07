package com.servlet.app.model.entity;

import java.text.DecimalFormat;
import org.apache.commons.lang3.StringUtils;

import com.servlet.database.Database;

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
        Database dbInstance = Database.getDbInstance();
        String allProduce =  " ";
        for (Product product : dbInstance.getProducts()) {        

            allProduce+="<div class='prod_item'>" +
                    "    <img src='prodIMG/' class='image_prod'/><br/>" +
                    "    <span class='prodName'>"+product.getProductName()+"</span><br/>" +
                    "    <span class='prodLocation'>"+product.getProductDescription()+"</span><br/>" +
                    "    <span class='prodPrice'>"+product.getPrice()+"</span><br/>" +
                    "</div>";
        }
        return allProduce;
    }   
    
}
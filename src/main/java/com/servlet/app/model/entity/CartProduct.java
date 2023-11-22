package com.servlet.app.model.entity;

import java.io.Serializable;

import com.servlet.view.html.HtmlTable;
import com.servlet.view.html.HtmlTableColHeader;

@HtmlTable(name = "Cart")
public class CartProduct implements Serializable{
    private int productId;
    
    @HtmlTableColHeader(header = "Product Name")
    private String prodName;

    @HtmlTableColHeader(header = "Price")
    private Double prodPrice;

    @HtmlTableColHeader(header = "Quantity")
    private int prodQuantity;

    private String prodDescription;

    public CartProduct() {
    }
    public String getProdDescription() {
        return prodDescription;
    }
    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }
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
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public CartProduct(int productId, String prodName, Double prodPrice, int prodQuantity, String prodDescription) {
        this.productId = productId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodQuantity = prodQuantity;
        this.prodDescription = prodDescription;
    }
    
    
}

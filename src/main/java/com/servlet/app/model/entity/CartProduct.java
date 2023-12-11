package com.servlet.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.servlet.view.html.annotation.FarmerHtmlFormField;
import com.servlet.view.html.annotation.FileTypeAnnot;
import com.servlet.view.html.annotation.HtmlTableColHeader;

@Entity
@Table(name = "CartItem")
public class CartProduct extends BaseEntity {

    @HtmlTableColHeader(header = "Product Name")
    @Column(name = "productName", columnDefinition = "VARCHAR(255)")
    private String prodName;

    @HtmlTableColHeader(header = "Price")
    @Column(name = "Price", columnDefinition = "INT(11)")
    private Double prodPrice;

    @Column(name = "productQuantity", columnDefinition = "INT(11)")
    @HtmlTableColHeader(header = "Quantity")
    private int prodQuantity;

    @Column(name = "productDescription", columnDefinition = "VARCHAR(255)")
    private String prodDescription;

    @HtmlTableColHeader(header = "Product Image")
    @Column(name = "imageName", columnDefinition = "VARCHAR(255)")
    @FarmerHtmlFormField(labelName = "Choose image")
    @FileTypeAnnot
    private String imageName;

    @Column(name = "productOwner",columnDefinition = "VARCHAR(255)")
    private String productOwner;
    

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

   

    public CartProduct(String prodName, Double prodPrice, int prodQuantity, String prodDescription, 
            String productOwner) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodQuantity = prodQuantity;
        this.prodDescription = prodDescription;
        this.productOwner = productOwner;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

}

package com.servlet.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.servlet.view.enums.ProductCategory;
import com.servlet.view.html.annotation.FarmerEnumAnnot;
import com.servlet.view.html.annotation.FarmerGridView;
import com.servlet.view.html.annotation.FarmerHtmlFormField;
import com.servlet.view.html.annotation.HtmlTableColHeader;
import com.servlet.view.html.annotation.NumericTypeAnnot;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "PurchasedProducts")
public class PurchasedProduct extends BaseEntity {


    @HtmlTableColHeader(header = "Product Name")
    @Column(name = "productName", columnDefinition = "VARCHAR(255)")
    @FarmerGridView(className = "prodName")
    @FarmerHtmlFormField(labelName = "Product Name", formType = "text", placeHolder = "E.g. Maize", formName = "productName")
    private String productName;

    @HtmlTableColHeader(header = "Product Category")
    @Column(name = "productCategory", columnDefinition = "VARCHAR(255)")
    @FarmerHtmlFormField(labelName = "Select the Product Category", formName = "productCategory")
    @FarmerEnumAnnot
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @HtmlTableColHeader(header = "Price")
    @Column(name = "Price", columnDefinition = "DOUBLE")
    private Double Price;

    @HtmlTableColHeader(header = "Product Quantity")
    @Column(name = "productQuantity", columnDefinition = "INT(11)")
    @FarmerHtmlFormField(labelName = "Product Quantity (Kg)", formType = "number", placeHolder = "Enter amount", formName = "prodQuantity")
    @NumericTypeAnnot
    private int prodQuantity;

    

    public PurchasedProduct() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    

}

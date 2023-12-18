package com.servlet.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.servlet.view.enums.ProductCategory;
import com.servlet.view.html.annotation.FarmerEnumAnnot;
import com.servlet.view.html.annotation.FarmerGridView;
import com.servlet.view.html.annotation.FarmerHtmlForm;
import com.servlet.view.html.annotation.FarmerHtmlFormField;
import com.servlet.view.html.annotation.FileTypeAnnot;
import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;
import com.servlet.view.html.annotation.NumericTypeAnnot;

@FarmerHtmlForm(label = "Product", action = "./produce")
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "Product")
@HtmlTable(addUrl = "./produce", deleteUrl = "./produce?type=product&mode=remove&id=", addToCart = "./cart?mode=add&id=")
@FileTypeAnnot
public class Product extends BaseEntity {

    @HtmlTableColHeader(header = "Product Name")
    @Column(name = "productName", columnDefinition = "VARCHAR(255)")
    @FarmerGridView(className = "prodName")
    @FarmerHtmlFormField(labelName = "Product Name", formType = "text", placeHolder = "E.g. Maize", formName = "productName")
    private String productName;

    @HtmlTableColHeader(header = "Product Description")
    @Column(name = "productDescription", columnDefinition = "VARCHAR(255)")
    @FarmerGridView(className = "prodLocation")
    @FarmerHtmlFormField(labelName = "Product Description", formType = "text", placeHolder = "your description", formName = "productDescription")
    private String productDescription;

    @HtmlTableColHeader(header = "Price")
    @Column(name = "price", columnDefinition = "DOUBLE")
    @FarmerGridView(className = "prodPrice")
    @FarmerHtmlFormField(labelName = "Product Price / Kg", formType = "number", placeHolder = "E.g.. 200", formName = "price")
    @NumericTypeAnnot
    private Double price;

    @HtmlTableColHeader(header = "Product Quantity")
    @Column(name = "productQuantity", columnDefinition = "INT(11)")
    @FarmerHtmlFormField(labelName = "Product Quantity (Kg)", formType = "number", placeHolder = "Enter amount", formName = "prodQuantity")
    @NumericTypeAnnot
    private int prodQuantity;

    @HtmlTableColHeader(header = "Product Category")
    @Column(name = "productCategory", columnDefinition = "VARCHAR(255)")
    @FarmerHtmlFormField(labelName = "Select the Product Category", formName = "productCategory")
    @FarmerEnumAnnot
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @Column(name = "imageName", columnDefinition = "VARCHAR(255)")
    @FarmerHtmlFormField(labelName = "Choose image", formType = "file", formName = "file")
    @FileTypeAnnot
    private String imageName;

    @Column(name = "productOwner", columnDefinition = "VARCHAR(255)")
    private String productOwner;

    @ManyToOne
    private User user;

    public int getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public Product() {
    }

    public Product(int id, String name, String description, double price, int prodQuantity) {
        super();
        this.productName = name;
        this.productDescription = description;
        this.price = price;
        this.prodQuantity = prodQuantity;
    }

    public Product(int id, String name, String description, double price, int prodQuantity,
            ProductCategory productCategory) {
        super();
        this.productName = name;
        this.productDescription = description;
        this.price = price;
        this.prodQuantity = prodQuantity;
        this.productCategory = productCategory;
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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Double getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
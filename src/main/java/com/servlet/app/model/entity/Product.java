package com.servlet.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.servlet.view.enums.ProductCategory;
import com.servlet.view.enums.PurchaseStatus;
import com.servlet.view.html.annotation.FarmerEnumAnnot;
import com.servlet.view.html.annotation.FarmerGridView;
import com.servlet.view.html.annotation.FarmerHtmlForm;
import com.servlet.view.html.annotation.FarmerHtmlFormField;
import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;
import com.servlet.view.html.annotation.NumericTypeAnnot;

@FarmerHtmlForm(label = "Product", action = "./produce")
@Entity
@Table(name="Product")
@HtmlTable(addUrl = "./produce",deleteUrl = "./produce?type=product&mode=remove&id=", addToCart = "./cart?mode=add&id=")
public class Product extends BaseEntity{

    @HtmlTableColHeader(header = "Product Name")
    @Column(name = "productName", columnDefinition = "VARCHAR(255)")
    @FarmerGridView(className = "prodName")
    @FarmerHtmlFormField(labelName = "Product Name",formType = "text", placeHolder = "E.g. Maize")
    private String productName;

    @HtmlTableColHeader(header = "Product Description")
    @Column(name = "productDescription", columnDefinition = "VARCHAR(255)")
    @FarmerGridView(className = "prodLocation")
    @FarmerHtmlFormField(labelName = "Product Description", formType = "text", placeHolder = "your description")
    private String productDescription;

    @HtmlTableColHeader(header = "Price")
    @Column(name="price", columnDefinition = "INT(11)")
    @FarmerGridView(className = "prodPrice")
    @FarmerHtmlFormField(labelName = "Product Price", formType = "number", placeHolder = "E.g.. 200")
    @NumericTypeAnnot
    private Double price;    

    @HtmlTableColHeader(header = "Product Quantity")
    @Column(name = "productQuantity", columnDefinition = "INT(11)")
    @FarmerHtmlFormField(labelName = "Product Quantity", formType = "number", placeHolder = "Enter amount")    
    @NumericTypeAnnot
    private int prodQuantity;

    @HtmlTableColHeader(header = "Product Category")
    @Column(name = "productCategory", columnDefinition = "VARCHAR(255)")
    @FarmerHtmlFormField(labelName = "Select the Product Category", formName = "")
    @FarmerEnumAnnot
    private ProductCategory productCategory;

    @Column(name = "productOwner",columnDefinition = "VARCHAR(255)")
    private String productOwner;

    @Column(name = "purchaseStatus",columnDefinition = "VARCHAR(255)")
    // @FarmerEnumAnnot
    private PurchaseStatus purchaseStatus;

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
        this.prodQuantity =prodQuantity;
    }
    public Product(int id, String name, String description, double price, int prodQuantity, ProductCategory productCategory) {
        super();
        this.productName = name;
        this.productDescription = description;
        this.price = price;
        this.prodQuantity =prodQuantity;
        this.productCategory=productCategory;
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


    public PurchaseStatus getPurchaseStatus() {
        return purchaseStatus;
    }


    public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }


    
}